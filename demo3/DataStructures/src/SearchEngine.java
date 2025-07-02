import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SearchEngine {
    public static void searchText(String file,String target) throws FileNotFoundException {
        StringBuilder sb=new StringBuilder();
        String line=null;
        try(BufferedReader bf=new BufferedReader(new FileReader(file))){
            while((line=bf.readLine())!=null){
                sb.append(line);
                sb.append("\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        String text=sb.toString();
        String[] words=text.split("\\s+");
        StringBuilder result=new StringBuilder();
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

        System.out.println(result);

        }





    public static void main(String[] args) throws FileNotFoundException {
        searchText("filePath","test");


    }
}
