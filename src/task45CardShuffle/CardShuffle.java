package task45CardShuffle;

public class CardShuffle {
    public static void main(String[] args) {
        String[] numbers =
                ("9129 8580 2658 19 10 77 9201 575 14 35 344 21 371 37 507 " +
                        "546 574 138 6970 5 4153 5002 460 63 386 2344 2673 " +
                        "80 701 211 10 6269 1623 5214 962 660 390 85 2354 " +
                        "450 460 3524 1308 365 8887 38 3351 677 431 36 771 3").split(" ");

        String[] ranks = "A, 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K".split(", ");
        String[] suits = {"C", "D", "H", "S"};
        String[] cards = new String[52];
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                cards[i*ranks.length+j] = suits[i]+ranks[j];
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i])>51?Integer.parseInt(numbers[i])%52:Integer.parseInt(numbers[i]);
            String temp = cards[i];
            cards[i] = cards[number];
            cards[number] = temp;


        }
        for (String s: cards){
            System.out.print(s+ " ");
        }
    }
}
