package task131FourPicsOneWord;


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] testWords = {

                "7 l n c u d f i h a c e",
                "14 r n t i o c u a p k l i g b a h f r o s r r",
                "10 m t o k g t u a i i g t n i l u",
                "14 d m w v i z x a e l l n o t i i d r y b o t",
                "7 n g i l a h g e l r x",
                "8 k s s u e p e l o o d i n",
                "11 v g k f u l a l x z b d i r t e h",
                "8 e e b l g s x t s t f s e",
                "9 i u r c a s e r f t s c t i",
                "8 w y s r w o t r k e y i m",
                "5 y v z c o u r d",
                "9 c e e h n s d t t c n i o d",
                "7 s r e e o w c k h w r",
                "12 y l l a c c e h y i k g l i n g w e i",
                "6 r x i e y s d l s e"
        };


        String result = "";
        Map<String, Integer> countAnagramWords = new HashMap<>();
        File dictionary = new File("C:\\JavaInterview\\CodeAbbey\\src\\task131FourPicsOneWord\\words_2.txt");
        fillAnagramsMap(countAnagramWords, dictionary);
        for (String s : testWords) {
            String anagram = getLetters(s);
            int count = Integer.parseInt(s.split(" ")[0]);
            int totalWords = 0;
            printCombination(anagram.toCharArray(), anagram.length(), count);
            for (String str : words) {
                int countAnagram = countAnagramWords.get(str) == null ? 0 : countAnagramWords.get(str);
                totalWords += countAnagram;
            }
            words.clear();
            result += (totalWords + " ");
        }
        System.out.println(result);
    }

    private static String getLetters(String s) {
        String[] splitted = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < splitted.length; i++) {
            stringBuilder.append(splitted[i]);
        }
        return stringBuilder.toString();
    }

    private static void fillAnagramsMap(Map<String, Integer> countAnagramWords, File dictionary) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dictionary))) {
            while (bufferedReader.ready()) {
                String word = createAnnagramsWord(bufferedReader.readLine());
                Integer getFromMap = countAnagramWords.get(word);
                countAnagramWords.put(word, getFromMap != null ? getFromMap + 1 : 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {

        }
    }

    private static String createAnnagramsWord(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static Set<String> words = new HashSet<>();

    static void combinationUtil(char arr[], char data[], int start,
                                int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            words.add(createAnnagramsWord(new String(data)));
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(char arr[], int n, int r) {
        // A temporary array to store all combination one by one
        char data[] = new char[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r);
    }

}
