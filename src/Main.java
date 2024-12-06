import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        /*Scanner fileInput=new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName=fileInput.nextLine();*/
        String path="C:\\Users\\90506\\OneDrive\\Masaüstü\\Proje\\Map1.txt";
        City[] map = {};
        FileReader myFile=new FileReader(path);
        int cityNumber = 0;
        int lineNumber=1;
        String[] cities={};
        int routes=0;
        int index=0;
        String destination=null;
        String targetL=null;
        String[][] route = new String[0][];
        String[] target=new String[2];
        try(BufferedReader bufferedReader=new BufferedReader(myFile)){
            String line;
            while((line=bufferedReader.readLine())!=null){
                if(lineNumber==1){
                    cityNumber=Integer.parseInt(line);
                    lineNumber++;
                    cities=new String[cityNumber];
                    map=new City[cityNumber];
                }
                else if(lineNumber==2){
                    cities=line.split(" ");
                    lineNumber++;
                }
                else if(lineNumber==3){
                   routes=Integer.parseInt(line); 
                   route=new String[3][routes];
                   lineNumber++;
                }
                else if(lineNumber==4){
                    route[index]=line.split(" ");
                    index++;
                    if(index==3){
                        lineNumber++;
                    }
                }
                else if(lineNumber==5){
                    target=line.split(" ");
                    destination=target[0];
                    targetL=target[1];
                }
            }
            System.out.println("City number:"+cityNumber);
            System.out.println("Route number:"+routes);
            System.out.println("Current Location:"+destination);
            System.out.println("Target Location:"+targetL);
            for(int i=0;i<cityNumber;i++){
                map[i]=new City(cities[i]);
                System.out.print(map[i].getName()+" ");;
            }
            System.out.println();
            for(int j=0;j<6;j++) {
                System.out.print(route[j][2]+" ");
            }



            
        }




    }
}