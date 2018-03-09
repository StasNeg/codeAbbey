package newCompetition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {

            List<String> words = new LinkedList<>();
            while (bufferedReader.ready()) {
                words.add(bufferedReader.readLine().toLowerCase());
            }
            Collections.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });
            String result = "";
            String temp = "";
            for (int i = 0; i < words.get(0).length(); i++) {
                temp += words.get(0).substring(i, i + 1);
                if (!isLetter(words, temp)) {
                    int length = temp.length() > 1 ? temp.length() - 1 : 1;
                    temp = length == 1 ? "" : temp.substring(0, length);
                    result = result.length() > temp.length() ? result : temp;
                    temp = "";
                }
            }
            result = result.length() > temp.length() ? result : temp;
            /* YOUR  CODE HERE */
            System.out.println(result.length() > 0 ? result : "0");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isLetter(List<String> words, String substring) {
        for (int i = 1; i < words.size(); i++) {
            if (!words.get(i).contains(substring)) return false;

        }
        return true;
    }

}