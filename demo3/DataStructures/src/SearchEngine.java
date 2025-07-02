import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchEngine {
    public static void searchText(String file,String target) throws FileNotFoundException {
        StringBuilder result=new StringBuilder();
        String line=null;
        try(BufferedReader bf=new BufferedReader(new FileReader(file))){
            while((line=bf.readLine())!=null){

                String[] words=line.split("\\s+");

                for(int i=0;i<words.length;i++){
                 String clean=words[i].replaceAll("\\p{Punct}","").toLowerCase().trim();
                 if(clean.isEmpty()) continue;
                 if (clean.equalsIgnoreCase(target)) {
                    result.append(" ");
                    result.append("<<" + words[i] + ">>");
                 } else {
                    result.append(" ");
                    result.append(words[i]);
                 }
             }
                result.append("\n");

        }
            System.out.println(result);

        }catch (IOException e){
          e.printStackTrace();
        }
    }





    public static void main(String[] args) throws FileNotFoundException {
        searchText("filePath.txt","frequency");


    }
}
