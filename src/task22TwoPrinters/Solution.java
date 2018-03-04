package task22TwoPrinters;

/**
 * Created by Stanislav on 04.03.2018.
 */
public class Solution {
    public static void main(String[] args) {
        String[] data = {
                "20 22 36970796",
                "5039861 24641734 28",
                "48 65 11063461",
                "2541972 4917302 89",
                "59812134 3410962 15",
                "108720 174140 5088",
                "61 15 13421117",
                "397 639 803101",
                "42066906 42644684 7",
                "2261971 245312 437",
                "16016 13242 51199",
                "248588 1371140 465",
                "229581502 132884698 3",
                "11767 18666 24193",
                "5961057 8458412 108"
        };
        String result = "";
        for (String s : data) {
            String[] splitted = s.split(" ");
            int first = Integer.parseInt(splitted[0]);
            int second = Integer.parseInt(splitted[1]);
            int countPage = Integer.parseInt(splitted[2]);
            if (first > second) {
                int temp = first;
                first = second;
                second = temp;
            }
            long countSecondsFirst = first;
            long countSecondsSecond = second;
            long countSecond = 0L;
            while (true) {
                long stopFirst = countPage - (countSecondsFirst / first + countSecondsFirst / second);
                long stopSecond = countPage - (countSecondsSecond / first + countSecondsSecond / second);

                if (stopFirst > 0) {
                    countSecondsFirst += first;
                }
                if (stopSecond > 0) {
                    countSecondsSecond += second;
                }
                if (stopFirst <= 0 && stopSecond <= 0) {
                    countSecond = countSecondsSecond > countSecondsFirst ? countSecondsFirst : countSecondsSecond;
                    break;
                }
            }
            result += countSecond + " ";
        }
        System.out.println(result);
    }
//    240780825 205565511 26025726 52849923 42791392 35323960 82851920 184596552 433104510 60295903 100256632 80496074 120108235 253141833 102751209 315206605
//    240780825 205565511 26025726 52849923 42791392 35323960 82851920 184596552 433104510 60295903 100256632 80496074 120108235 253141833 102751209 315206605
}
