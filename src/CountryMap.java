import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class CountryMap {
    private City[] cities;
    private int [][] times;
    private int cityCount;


     public void checkInput(File file) throws FileNotFoundException {

        if(file.exists()) {
            System.out.println("File not found");
            return;
        }
        else{

            Scanner myReader=new Scanner(file);
            String[] errors=new String[100];
            int errorCount = 0;
            String line=myReader.nextLine();
            cityCount=Integer.parseInt(line);
            line = myReader.nextLine();
            String[] citys=line.split(" ");
            line=myReader.nextLine();
            int routes=Integer.parseInt(line);

            System.out.println("City count: "+cityCount);
            for(int i=0; i<cityCount; i++) {
                System.out.print(citys[i]+" ");
            }
            System.out.println("Route number:"+routes);

        }
    }


 }