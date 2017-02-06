/*
 * Created by Gareth Marriott
 * v00875748
 * Extra sorts the word list dump in order of most common to least common
 */

import java.io.*;
import java.util.*;

public class TextAnalysisExtra {

    public static String getLongestWord(String[] words){
        String longest = "";

        for(int i = 0; i < words.length; i++){
            if(words[i].length() > longest.length()){
                longest = words[i];
            }
        }

        return longest;
    }

    public static void main(String[] args) throws Exception{
        String fileName = args.length == 1 ? args[0] : "C:\\UVIC\\in01.txt";
        Scanner in = new Scanner(new File(fileName));

        String[] listOfWords = wordSeparator(in);
        String longestWord = getLongestWord(listOfWords);
        HashMap<String , Integer> words = wordOccurrence(listOfWords);



        System.out.println();
        System.out.println("TEXT FILE STATISTICS");
        System.out.println("--------------------");
        System.out.println("Length of longest word: " + longestWord.length() + " (\"" + longestWord + "\")");
        System.out.println("Number of words in file wordlist: " + words.size());
        System.out.println("Number of words in file: " + listOfWords.length);

        printStats(listOfWords);

        printFrequency(words);

//        dumpArray(listOfWords);
    }

// *** For testing purposes***
//    public static void dumpArray(String[] arr){
//        for(int i = 0; i < arr.length; i++){
//
//            System.out.println(arr[i]);
//        }
//    }

    // Takes in String of text and separates/lowercases all words
    public static String[] wordSeparator(Scanner in) throws FileNotFoundException{

        int maxListSize = 10000000;
        String[] buffer = new String[maxListSize];
        int listSize = 0;

        for (int i = 0; (i < maxListSize) && in.hasNext(); i++){
            buffer[i] = in.next().toLowerCase();
            listSize ++;
        }

        String[] wordList = new String[listSize];

        System.arraycopy(buffer , 0 , wordList , 0 , listSize);

    return wordList;
    }


// Hashmap for counting occurence of each word
    public static HashMap<String, Integer> wordOccurrence(String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

        for(int i=0; i<words.length; i++) {
            Integer count = wordMap.get(words[i]);
            if ( count == null ) {
                wordMap.put(words[i], new Integer(1));
            } else {
                wordMap.put(words[i], new Integer(count.intValue() + 1));
            }
        }

        return wordMap;
    }

    public static void printFrequency(HashMap<String , Integer> words){

        System.out.println("\nWordlist dump:");
        words.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())  // EXTRA
        .forEach(System.out::println);
    }


// Prints how many of each length of word
    public static void printStats(String[] words){

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int tenOrMore = 0;


        for(int i = 0; i < words.length; i++){
            if(words[i].length() == 1){
                one = one + 1;
            }
            if(words[i].length() == 2){
                two = two + 1;
            }
            if(words[i].length() == 3){
                three = three + 1;
            }
            if(words[i].length() == 4){
                four = four + 1;
            }
            if(words[i].length() == 5){
                five = five + 1;
            }
            if(words[i].length() == 6){
                six = six + 1;
            }
            if(words[i].length() == 7){
                seven = seven + 1;
            }
            if(words[i].length() == 8){
                eight = eight + 1;
            }
            if(words[i].length() == 9){
                nine = nine + 1;
            }
            if(words[i].length() >= 10){
                tenOrMore = tenOrMore + 1;
            }
        }
        System.out.println();
        System.out.println("Word-frequency statistics");
        System.out.println("Word-length 1:" + one);
        System.out.println("Word-length 2:" + two);
        System.out.println("Word-length 3:" + three);
        System.out.println("Word-length 4:" + four);
        System.out.println("Word-length 5:" + five);
        System.out.println("Word-length 6:" + six);
        System.out.println("Word-length 7:" + seven);
        System.out.println("Word-length 8:" + eight);
        System.out.println("Word-length 9:" + nine);
        System.out.println("Word-length >= 10:" + tenOrMore);



    }

}
