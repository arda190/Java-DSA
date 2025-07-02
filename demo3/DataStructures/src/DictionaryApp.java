import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryApp {
    public static void writeToFile(String filename, String content) {
        try(FileWriter fw = new FileWriter(filename,true)) {
            fw.write("\n"+content);
        }catch(IOException ioe) {
            System.out.println("Error writing to file");
        }
    }

    public static ArrayList<String> readFromFile(String filename) {
        ArrayList<String> list = new ArrayList<>();
        String line="";
        try(BufferedReader bf=new BufferedReader(new FileReader(filename))) {
            while((line=bf.readLine())!=null) {
                list.add(line.trim());
            }
        }catch(IOException ioe) {
            System.out.println("Error reading from file");
        }
        return list;
    }

    public static String getWord(ArrayList<String> list, String word) {
        for(int i=0;i<list.size();i++) {
            String temp=list.get(i).toLowerCase().split("\\s+")[1];
            if(temp.equals(word.toLowerCase())) {
                return list.get(i).split(" ")[0];
            }
        }
        return null;
    }

    public static void removeWord(ArrayList<String> list, String word,String filePath) {
        for(int i=0;i<list.size();i++) {
            String temp=list.get(i).toLowerCase().split("\\s+")[1];
            if(temp.equals(word.toLowerCase())) {
                list.remove(i);
            }
        }
        writeContentToFile(list,filePath);
    }

    private static void writeContentToFile(ArrayList<String> list,String file) {
        try(FileWriter fw=new FileWriter(file,false)){
            for(int i=0;i<list.size();i++) {
                fw.write(list.get(i)+"\n");
            }
        }catch(IOException ioe) {
            System.out.println("Error writing to file");
        }
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\90506\\IdeaProjects\\demo3\\DataStructures\\src\\wordList.txt";
        System.out.println("Welcome to the Dictionary App");
        System.out.println("Please enter the number you would like to do");
        System.out.println("1-Search a word");
        System.out.println("2-Add a word");
        System.out.println("3-Remove a word");
        System.out.println("4-Exit");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            choice = sc.nextInt();
            sc.nextLine();
         switch(choice) {
             case 1:
                 System.out.println("Enter the word you would like to search");
                 String word=sc.nextLine();
                 ArrayList<String> list=readFromFile(fileName);
                 String target=getWord(list,word);
                 if(target==null) {
                     System.out.println("Word not found");
                 }
                 else {
                     System.out.println(word+":"+target);
                 }
                 break;
             case 2:
                 System.out.println("Enter the word you would like to add");
                 String addWord=sc.nextLine();
                 writeToFile(fileName,addWord);
                 break;
             case 3:
                 System.out.println("Enter the word you would like to remove");
                 String removeWord=sc.nextLine();
                 ArrayList<String> list1=readFromFile(fileName);
                 removeWord(list1,removeWord,fileName);
                 break;
         }
        }while(choice!=4);

        }

    }


