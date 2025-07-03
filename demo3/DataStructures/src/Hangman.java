import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Hangman{
    static int life=5;
    static int guess=0;
    static HashSet<Character> guessedWords=new HashSet<Character>();




    public static ArrayList<String> readFromFile(String fileName){
        ArrayList<String> words = new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(fileName))){
            String line;
            while((line=bf.readLine())!=null){
                words.add(line);
            }
        }catch(Exception e){
            System.out.println("Exception occured");
        }
        return words;
    }

    private static String chooseWord(ArrayList<String> words){
        int randomNumber=(int)(Math.random()*(words.size()));
        return words.get(randomNumber);
    }




    public static void startGame(String filePath){
        ArrayList<String> words = readFromFile(filePath);
        String questionWord = chooseWord(words);
        int len=questionWord.length();
        int starterWords=len/3;

        for(int i=0;i<len;i++){
            System.out.print("_ ");
        }
        System.out.print(" ("+len+")  ");
        for (int j=0;j<5;j++){
            System.out.print(" ");
        }
        System.out.print("Your life:");
        for(int k=0;k<life;k++){
            System.out.print("*");
        }
        System.out.print("("+life+")");


        while(life>0 && guess<len){
            System.out.print(" ");
            char letter=getInput();
            int num=checkLetter(questionWord,letter);
            char[] letterArray=questionWord.toCharArray();
            StringBuilder sb=new StringBuilder();
            if(num!=0){
                for(char c:letterArray){
                    if(guessedWords.contains(c)){
                        sb.append(c+" ");
                        continue;
                    }
                    else if(c==letter){
                        sb.append(c+" ");
                        guess++;
                        guessedWords.add(c);
                    }
                    else{
                        sb.append("_ ");
                    }
                }
            }
            else{
                num=0;
                life--;
            }
            System.out.print(sb.toString()+" ");
            System.out.print("Your life:");
            for(int k=0;k<life;k++){
                System.out.print("*");
            }
            System.out.print("("+life+")");






        }

        if(life==0){
            System.out.println("You lost the game");
            System.out.println("The word is "+questionWord);
        }
        else if(guess==len){
            System.out.println("You win the game");
        }




    }


    private static char getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char letter=sc.nextLine().charAt(0);
        return letter;
    }

    private static int checkLetter(String word,char letter){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<word.length();i++){
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0)+1);
        }
        return map.getOrDefault(letter,0);
    }










    public static void main(String[] args) {
        String filePath="hangmanWord.txt";
        startGame(filePath);
    }









}
