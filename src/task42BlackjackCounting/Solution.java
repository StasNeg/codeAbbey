package task42BlackjackCounting;


import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String[] data = {
                "Q 4 A 9",
                "J 2 8",
                "9 2 A 4",
                "3 Q T",
                "Q A",
                "A 9",
                "J 8",
                "3 6 7",
                "7 Q",
                "3 J T",
                "A 4 A",
                "A A 7",
                "J 5 Q",
                "3 3 9 J",
                "J A",
                "J 4 J",
                "8 J",
                "T 5 A",
                "3 A A 9 8",
                "7 A",
                "K 7",
                "6 J",
                "5 3 7 9",
                "5 J 7",
                "3 5 J",
                "J 2 5"
        };
        HashMap<String, Integer> cards = new HashMap<>();
        for (int i = 2; i < 11; i++) {
            if (i == 10)
                cards.put("T", i);
            else
                cards.put("" + i, i);
        }
        cards.put("J", 10);
        cards.put("Q", 10);
        cards.put("K", 10);
        String result = "";
        for (String game : data) {
            String[] hand = game.split(" ");
            int sum = 0;
            int countAce = 0;
            for (String card : hand) {
                if (card.equals("A")) {
                    countAce++;
                } else {
                    sum += cards.get(card);
                }
            }
            if (countAce != 0) {
                sum = countSumWithAce(sum, countAce);
            }
            result += sum <= 21 ? sum + " " : "Bust ";
        }
        System.out.println(result);
    }

    private static int countSumWithAce(int sum, int countAce) {
        int result = 0;
        if ((countAce-1) + 11 +sum <= 21) {
            result = (countAce-1) + 11 +sum;
        }
        else
            result = countAce +sum;

        return result;
    }
}
