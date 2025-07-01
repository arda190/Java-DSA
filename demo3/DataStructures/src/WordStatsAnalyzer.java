import java.io.*;
import java.util.*;
public class WordStatsAnalyzer {

    public static void getWords(String file)throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        int nextChar = 0;
        try (FileReader fr = new FileReader(file)) {
            while ((nextChar = fr.read()) != -1) {
                sb.append((char) nextChar);
            }
        }
        String text = sb.toString();
        text = text.replaceAll("\\p{Punct}", "");
        String[] words = text.split("\\s+");

        for (String word : words) {
            if (map.containsKey(word.toLowerCase().trim())) {
                map.put(word.toLowerCase().trim(), map.get(word.toLowerCase().trim()) + 1);
            } else {
                map.put(word.toLowerCase().trim(), 1);
            }
        }


        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Comparator.comparing(Map.Entry::getValue));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


        public static void main(String[] args) {
        try{
            getWords("C:\\Users\\90506\\IdeaProjects\\demo3\\DataStructures\\src\\example2.txt");
        }catch(IOException e){
            e.printStackTrace();
        }
    }



}
