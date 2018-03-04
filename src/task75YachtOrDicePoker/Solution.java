package task75YachtOrDicePoker;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    //        all five dice have the same points, like 2 2 2 2 2; (1 length)
    final static String YACHT = "yacht";

    //        four of dice have the same points, like 1 4 1 1 1 (2 length)
    final static String FOUR = "four";
    //        pair and three at once, like 1 6 6 1 6 (2 length)
    final static String FULL_HUOSE = "full-house";

    //        three of dice have the same points, like 2 4 5 4 4 (3 length)
    final static String THREE = "three";
    //        two pairs at once, like 3 6 5 3 5 (3 length)
    final static String TWO_PAIRS = "two-pairs";


    //      two of dice have the same points, like 3 6 5 6 1 (4 length)
    final static String PAIR = "pair";


    //        sequence from 1 to 5, like 2 4 3 5 1 (5 length)
    final static String SMALL_STRAIGHT = "small-straight";
    //        sequence from 2 to 6, like 6 3 4 2 5 (5 length)
    final static String BIG_STRAIGHT = "big-straight";

    final static String NONE = "none";


    public static void main(String[] args) {
        String[] data = {
                "6 6 6 6 5",
                "2 2 5 1 6",
                "3 1 3 4 3",
                "4 5 3 1 4",
                "5 5 6 1 2",
                "5 2 6 5 5",
                "1 6 3 3 6",
                "1 1 5 2 5",
                "2 3 4 5 1",
                "2 3 4 5 1",
                "4 1 3 4 2",
                "4 2 6 3 1",
                "3 1 2 4 6",
                "1 6 3 2 1",
                "2 3 4 5 1",
                "3 3 6 5 1",
                "6 3 1 2 1",
                "3 1 1 4 6",
                "5 1 1 4 5",
                "2 3 4 5 6",
                "2 3 4 5 1",
                "3 5 3 6 1",
                "2 3 4 5 6",
                "2 3 4 5 6",
                "4 5 5 5 3",
                "2 3 4 5 6",
                "2 3 4 5 6",
                "6 4 6 6 2"
        };
        String result = "";
        for (String variety : data) {
            Map<String, Integer> combination = new HashMap<>();
            String[] numbers = variety.split(" ");
            for (String number : numbers) {
                combination.put(number, combination.get(number) == null ? 1 : combination.get(number) + 1);
            }
            switch (combination.keySet().size()) {
                case 1:
                    result += (YACHT + " ");
                    break;
                case 2:
                    result += (resolveTwo(combination) + " ");
                    break;
                case 3:
                    result += (resolveThree(combination) + " ");
                    break;
                case 4:
                    result += (PAIR + " ");
                    break;
                case 5:
                    result += (resolveFive(combination) + " ");
                    break;
            }
        }
        System.out.println(result);
    }

    private static String resolveTwo(Map<String, Integer> combination) {
        return combination.values().stream().filter(x -> x == 4).findFirst().orElse(0) == 0 ? FULL_HUOSE : FOUR;
    }

    private static String resolveThree(Map<String, Integer> combination) {
        return combination.values().stream().filter(x -> x == 3).findFirst().orElse(0) == 0 ? TWO_PAIRS : THREE;
    }

    private static String resolveFive(Map<String, Integer> combination) {
        StringBuilder str = new StringBuilder();
        combination.keySet().stream().sorted(Comparator.naturalOrder()).forEach(str::append);
        String result = str.toString();
        if("12345".equals(result)) return SMALL_STRAIGHT;
        if("23456".equals(result)) return BIG_STRAIGHT;
        return NONE;
    }
}
