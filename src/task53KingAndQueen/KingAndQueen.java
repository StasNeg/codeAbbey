package task53KingAndQueen;

/**
 * Created by Stanislav on 07.01.2018.
 */
public class KingAndQueen {
    public static void main(String[] args) {
        int count = 22;
        String[] strings = {
                "d5 e2",
                "g2 a5",
                "c2 a2",
                "g6 e6",
                "e3 b8",
                "a3 h1",
                "c5 b1",
                "b5 b6",
                "b7 h8",
                "h8 d3",
                "a5 e8",
                "b1 e7",
                "c6 f4",
                "h6 d3",
                "b6 c4",
                "c5 b4",
                "d1 c4",
                "a7 g2",
                "c3 a5",
                "d5 c7",
                "b1 b2",
                "f6 d8"};
        for (String s : strings) {
            String [] kingAndQueen = s.split(" ");
            if(kingAndQueen[0].substring(0,1).equals(kingAndQueen[1].substring(0,1)) || kingAndQueen[0].substring(1,2).equals(kingAndQueen[1].substring(1,2))){
                System.out.print("Y ");
                continue;
            }
            if(Math.abs(kingAndQueen[0].substring(0,1).charAt(0)-kingAndQueen[1].substring(0,1).charAt(0)) == Math.abs(kingAndQueen[0].substring(1,2).charAt(0)-kingAndQueen[1].substring(1,2).charAt(0))){
                System.out.print("Y ");
                continue;
            }
            System.out.print("N ");
        }
    }
}
