import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyMain {

    public static void writeOutput(String output,String filePath) throws IOException {
        try(FileWriter writer = new FileWriter(filePath);){
            writer.write(output);
            System.out.println("Output succesfully written to "+filePath);
        }
        catch(IOException e){
            System.out.println("Error writing output:"+e.getMessage());
        }

    }


    public static boolean isInteger(String s) {
        try{
            Integer.parseInt(s);
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
            if(!isLetter(a)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String line;
        int errorLine=0;
        boolean isError=false;
        String errors[]=new String[10];
        int index=0;
        int route = 0;
        int cityNumber=0;
        String destination=null;
        String target=null;
        int cityIndex=0;
        int routesIndex=0;
        String[][] routes=new String[0][0];
        String[] cities = new String[0];
        String path="C:\\Users\\90506\\OneDrive\\Masaüstü\\Proje\\Map2.txt";
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(path))) {
            errorLine++;
            if((line=bufferedReader.readLine())!=null){
                if(!isInteger(line)){
                    errors[index]="<"+errorLine+">"+"<It must be an integer>";
                    isError=true;
                    //errorLine++;
                    index++;
                }
                else{
                    cityNumber=Integer.parseInt(line);
                    cities=new String[cityNumber];
                }
            }
            while((line=bufferedReader.readLine())!=null){
                String[] parts=line.split(" ");
                errorLine++;
                for(String a:parts){
                    if(!isLetter(a)){
                        errors[index]="<"+errorLine+">"+"<They must be a letter>";
                        isError=true;
                        //errorLine++;
                        index++;
                        break;
                    }
                    else{
                        cities[cityIndex]=a;
                        cityIndex++;
                    }
                }
                break;
            }
            errorLine++;
            if((line=bufferedReader.readLine())!=null){
                if(!isInteger(line)){
                    errors[index]="<"+errorLine+">"+"<It must be an integer>";
                    isError=true;
                }
                else {
                    route = Integer.parseInt(line);
                    routes=new String[route][3];

                }
            }
            boolean flag=true;
            boolean errorCheck=true;
            while(((line=bufferedReader.readLine())!=null)&&(flag)){
                String[] parts=line.split(" ");
                if(errorCheck) {
                    errorLine++;
                }
                    if(isLetter(parts[0])&& isLetter(parts[1]) &&isInteger(parts[2])){
                        if(!isError){
                        routes[routesIndex][0]=parts[0];
                        routes[routesIndex][1]=parts[1];
                        routes[routesIndex][2]=parts[2];}
                        route-=1;
                        routesIndex++;
                        if(routesIndex==routes.length){
                            flag=false;
                        }
                    }
                    else{
                        if(errorCheck){
                        errors[index]="<"+errorLine+">"+"<They must be this format:\"City City Time\">";
                        index++;
                        isError=true;
                        route-=1;
                        }
                    }
                if(route==1){
                    errorCheck=false;

                }

            }
            if((line=bufferedReader.readLine())!=null){
                String[] parts=line.split(" ");
                errorLine++;
                if(!(isLetter(parts[0])&& isLetter(parts[1]))){
                    errors[index]="<"+errorLine+">"+"<They must be this format:\"City City\">";
                }
                else{
                    destination=parts[0];
                    target=parts[1];
                    System.out.println("Çalıstı");
                }
            }



           if(isError){
               for(String a:errors){
                   if(a!=null){
                       System.out.println(a);
                   }
               }
           }
           else{
               System.out.println("File reading is successful");
           }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    if(!isError){
        System.out.println(destination+"->"+target);
        System.out.println(cities[0]+"->"+cities[1]+"->"+cities[2]+"->"+cities[3]+"->"+cities[4]);
        for(String[] s:routes){
            System.out.println(s[0]+"->"+s[1]+"--"+s[2]);
        }
    }




    }


}
