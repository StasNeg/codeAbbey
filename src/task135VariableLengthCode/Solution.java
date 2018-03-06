package task135VariableLengthCode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static final Map<String, String> CODE = new HashMap<>();

    static {
        CODE.put(" ", "11");
        CODE.put("t", "1001");
        CODE.put("n", "10000");
        CODE.put("s", "0101");
        CODE.put("r", "01000");
        CODE.put("d", "00101");
        CODE.put("!", "001000");
        CODE.put("c", "000101");
        CODE.put("m", "000011");
        CODE.put("g", "0000100");
        CODE.put("b", "0000010");
        CODE.put("v", "00000001");
        CODE.put("k", "0000000001");
        CODE.put("q", "000000000001");
        CODE.put("e", "101");
        CODE.put("o", "10001");
        CODE.put("a", "011");
        CODE.put("i", "01001");
        CODE.put("h", "0011");
        CODE.put("l", "001001");
        CODE.put("u", "00011");
        CODE.put("f", "000100");
        CODE.put("p", "0000101");
        CODE.put("w", "0000011");
        CODE.put("y", "0000001");
        CODE.put("j", "000000001");
        CODE.put("x", "00000000001");
        CODE.put("z", "000000000000");
    }

    public static void main(String[] args) {
        String data = "our towns and destroyed the lives of our people !he is at this time transporting in !peace !friends !we therefore the !representatives of the united !states of !america these rights !governments are instituted among !men deriving their just";
        System.out.println(stringToHec(data));

    }

    private static String stringToHec(String data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            builder.append(CODE.get(data.substring(i, i + 1)));
        }
        int numberAddzero = builder.length() % 8 == 0 ? 0 : 8 - builder.length() % 8;
        for (int i = 0; i < numberAddzero; i++) {
            builder.append("0");
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= builder.length() - 8; i += 8) {
            String hexString = Integer.toHexString(Integer.parseInt(builder.substring(i, i + 8), 2));
            hexString = hexString.length() == 1 ? "0" + hexString : hexString;
            result.append(hexString).append(" ");
        }
        return result.toString().toUpperCase();
    }
//12 28 E4 EE 8A 2C A6 46 5B C4 4E 23 46 98 4D 84 A6 30 5C B1 D3 E 4E E4 41 87 77 2 E0 80 E4 31 C9 C5 9 90 3C 44 E4 EE 41 2C 1A E9 86 F8 54 84 30 51 1A 13 00 99 1 51 10 14 C0 5B D5 96 8 94 A9 A6 1 39 3A 8A 98 6E 19 D 00 93 28 68 3 84 88 D 44 3 B0 9E 50 39 35 E6 38 2B AD 24 4A 2 92 D8 4F 26 E7 64 93 87 61 B4 5C 54 57 34 BD 00 11 B2 79 37 3C 9D 3 B4 50
}
