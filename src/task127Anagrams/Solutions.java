package task127Anagrams;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solutions {

    public static void main(String[] args) {
        String[] testWords = {
                "rangiest",
                "altered",
                "warders",
                "passer",
                "predator",
                "parcels",
                "aridest",
                "nerdiest",
                "tasking"};
        String result = "";
        Map<String, Integer> countAnagramWords = new HashMap<>();
        File dictionary = new File("C:\\JavaInterview\\CodeAbbey\\src\\task127Anagrams\\words.txt");
        fillAnagramsMap(countAnagramWords, dictionary);
        for (String s : testWords) {
            String anagram = createAnnagramsWord(s);
            int countAnagram = countAnagramWords.get(anagram) == null ? 0 : countAnagramWords.get(anagram);
            result += (countAnagram + " ");
        }
        System.out.println(result);
    }

    private static void fillAnagramsMap(Map<String, Integer> countAnagramWords, File dictionary) {
       try(BufferedReader bufferedReader = new BufferedReader(new FileReader(dictionary))){
           while (bufferedReader.ready()){
               String word = createAnnagramsWord(bufferedReader.readLine());
               Integer getFromMap = countAnagramWords.get(word);
               countAnagramWords.put(word, getFromMap != null ? getFromMap + 1 : 0);
           }
       }catch (FileNotFoundException e){
           System.out.println("file not found");
       }catch (IOException e){

       }
    }

    private static String createAnnagramsWord(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
