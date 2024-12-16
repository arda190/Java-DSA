import java.io.*;
import java.io.*;
import java.util.*;
public class Main{

    public static int getCityNumber(String fileName) {
        int cityNumber = 0;
        String line;
        try (BufferedReader myReader = new BufferedReader(new FileReader(fileName))) {
            if ((line = myReader.readLine()) != null) {
                cityNumber = Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return cityNumber;
    }
    public static String[] getCities(String fileName) {
        String[] cities = new String[getCityNumber(fileName)];
        String line;
        int count=1;
        try (BufferedReader myReader = new BufferedReader(new FileReader(fileName))) {
            boolean flag=true;
            while((line = myReader.readLine()) != null && flag) {
                if(count==2){
                    cities=line.split(",");
                    flag=false;
                }
                count++;
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return cities;
    }
    public static int getRouteNumber(String fileName) {
        int route = 0;
        String line;
        int count=1;
        try (BufferedReader myReader = new BufferedReader(new FileReader(fileName))) {
            boolean flag=true;
            while((line = myReader.readLine()) != null && flag) {
                if(count==3){
                    route=Integer.parseInt(line);
                    flag=false;
                }
                count++;

            }
        } catch (Exception e) {

        }
        return route;
    }
    public static String[][] getRoutes(String fileName) {
        int route=getRouteNumber(fileName);
        String[][] routes = new String[route][3];
        String line;
        int count=1;
        int index=0;
        try (BufferedReader myReader = new BufferedReader(new FileReader(fileName))) {
            boolean flag=true;
            while((line = myReader.readLine()) != null && flag) {
                if(count>=4 && count<(4+route)){
                    routes[index][0]=line.split(" ")[0];
                    routes[index][1]=line.split(" ")[1];
                    routes[index][2]=line.split(" ")[2];
                    index++;
                    count++;
                }
                else if(count==(4+route)){
                    flag=false;
                }
                else {
                    count++;
                }
                //return routes;
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

        return routes;
    }
    public static String[] getTarget(String fileName) throws FileNotFoundException {
        String line;
        int count=1;
        int targetLine=getRouteNumber(fileName)+4;
        String[] target=new String[2];
        try(BufferedReader myReader=new BufferedReader(new FileReader(fileName))){
            boolean flag=true;
            while((line=myReader.readLine())!=null && flag) {
                if(count==targetLine){
                    target=line.split(" ");
                    flag=false;
                }
                else{
                    count++;
                }
            }

        } catch (IOException e) {
            System.out.println("File not found");
        }
        return target;
    }




    public static boolean isInteger(String s) {
        try{
            Integer.parseInt(s.trim());
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean isLetter(String s) {
        return s.length()==1 && Character.isLetter(s.charAt(0));
    }
    public static boolean areTheyLetter(String[]s){
        for(String a:s){
            if(!isLetter(a.trim())){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) throws FileNotFoundException {
        //String filename=args[0];
        String filename = "C:\\Users\\90506\\OneDrive\\Masaüstü\\Proje\\Map23.txt";
        //filename="Map100.txt";
        //filename=args[0];
        int lineNumber = 0;
        //int cityNumber = getCityNumber(filename);
        int cityNumber=0;
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNext()) {
                sc.nextLine();
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.exit(0);

        }

        String line;
        String[] errors = new String[lineNumber];
        boolean isError = false;
        int errorLine = 1;
        int index = 0;
        int route = 0;
        //BufferedReader myReader = new BufferedReader(new FileReader(filename))
        try (BufferedReader myReader = new BufferedReader(new FileReader(filename))) {
            if ((line = myReader.readLine()) != null) {
                if (!isInteger(line)||Integer.parseInt(line)<=0) {
                    errors[index] = "<" + errorLine + ">" + "First line must be a positive integer representing the number of cities.";
                    isError = true;
                    index++;
                }

            }

            errorLine++;
            if ((line = myReader.readLine()) != null && !isError) {
                cityNumber = getCityNumber(filename);
                String[] parts = line.split(" ");
                if (parts.length != cityNumber) {
                    errors[index] = "<" + errorLine + ">" + "There should be " + cityNumber + " cities, but there are " + parts.length + " city are listed.";
                    index++;
                    isError = true;
                }

                for (String a : parts) {
                    if (!isLetter(a)) {
                        errors[index] = "<" + errorLine + ">" + "City names must consist of single letters.";
                        isError = true;
                        index++;
                        break;
                    }
                }
            }

            errorLine++;
            if ((line = myReader.readLine()) != null) {
                if (!isInteger(line)) {
                    errors[index] = "<" + errorLine + ">" + "Number of routes must be a positive integer.";
                    isError = true;
                    index++;
                } else {
                    route = Integer.parseInt(line);
                }
            }

            errorLine++;
            boolean flag = true;
            int numberOfRoutes = getRouteNumber(filename);
            int start = errorLine;
            for (int i = 0; i < lineNumber - 4; i++) {
                if ((line = myReader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (!(isLetter(parts[0]) && isLetter(parts[1]) && isInteger(parts[2]))) {
                        errors[index] = "<" + errorLine + ">" + "It must be this format <City City Time>.";
                        isError = true;
                        index++;
                    }
                    errorLine++;
                }
            }
            int currentRouteNumber = errorLine - start;
            if (numberOfRoutes != 0) {
                if (currentRouteNumber != numberOfRoutes) {
                    errors[index] = "<" + "4-" + (errorLine - 1) + ">" + "There should be " + numberOfRoutes + " routes, but there are " + currentRouteNumber + " routes.";
                    isError = true;
                    index++;
                }
            }

            if ((line = myReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (!(isLetter(parts[0]) && isLetter(parts[1]))) {
                    errors[index] = "<" + errorLine + ">" + "It must be this format <City City>.";
                }
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        if (isError) {
            for (String a : errors) {
                if (a != null) {
                    System.out.println(a);
                }
            }
        } else {
            System.out.println("File read is successful!");

            String[]cityList=getCities(filename)[0].split(" ");

            City[] cities=new City[cityNumber];
            for(int i=0;i<cityNumber;i++){
                cities[i]=new City(cityList[i],i);
            }


            CountryMap map=new CountryMap(cities,getRoutes(filename),getRouteNumber(filename));
            WayFinder wf=new WayFinder(map);
            String[] d=getTarget(filename);
            String start=d[0];
            String end=d[1];
            String result=wf.findFastestWay(start,end);

            if(result!=null) {

                Formatter f = null;
                try {
                    f = new Formatter("fastestWay.txt");
                    f.format("%s", result);
                    System.out.println("Fastest way are written to file fastestWay.txt");
                } catch (Exception e) {
                    System.out.println("Something went wrong");
                } finally {
                    if (f != null) {
                        f.close();
                    }
                }
            }
        }

    }

}


