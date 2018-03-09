package task158HammingCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] dataToHammingCode = {
                "0010101110100111",
                "101101011001000000",
                "001010110011100110000",
                "1100111100010",
                "000010100111001101101000",
                "0101100010001111010",
                "001000110000001011111011",
                "000000110110000",
                "1110101100",
                "010010111010000010011",
                "1100011011",
                "111000111011111011",
                "00011100110001010100110",
                "1101000000111101",
                "100101110010001",
                "10001011100110011001"
        };
        String[] dataFromHammingCode = {
                "11001000100111",
                "01001101100000",
                "10011101100000000011",
                "01111001111000000",
                "11110011100010111110",
                "1100001001010101100011001",
                "1000011",
                "1001101100001001010",
                "0101011111011010110110",
                "1101100101",
                "0101010000",
                "10011011101101100",
                "010111011011101111100001100",
                "110011100111010110011000100010",
                "01101011100001110100110101",
                "0110111101"

        };

        String result = "";
        for (int i = 0; i < dataToHammingCode.length; i++) {
            List<Integer> values = dataToHammingCode[i].chars().map(x -> x - '0').boxed().collect(Collectors.toList());
            addParityBits(values);
            for (Integer temp : values) {
                result += temp;
            }
            result += " ";
        }
        for (int i = 0; i < dataFromHammingCode.length; i++) {
            List<Integer> values = dataFromHammingCode[i].chars().map(x -> x - '0').boxed().collect(Collectors.toList());
            values = sheckAndDeleteParityBits(values);
            for (Integer temp : values) {
                result += temp;
            }
            result += " ";
        }
        System.out.println(result);

    }

    private static List<Integer> sheckAndDeleteParityBits(List<Integer> values) {
        Map<Integer, Integer> wrongParity = new HashMap<>();
        for (int i = 1; i < values.size(); i *= 2) {
            Integer temp = defineParityBit(values, i, 0);
            if (!temp.equals(values.get(i - 1))) {
                wrongParity.put(i, temp);
            }
        }
        if (wrongParity.size() > 0) {
            int wrongIndex = 0;
            for (Integer index : wrongParity.keySet()) {
                wrongIndex += index;
            }
            values.set(wrongIndex - 1, values.get(wrongIndex - 1) == 0 ? 1 : 0);
        }
        List<Integer> tempList = new ArrayList<>();
        for (int i = 1; i <= values.size(); i++) {
            if (i == 1 || isPowerOfTwo(i)) continue;
            tempList.add(values.get(i - 1));
        }
        return tempList;
    }

    private static boolean isPowerOfTwo(int i) {
        do {
            if (i % 2 == 0)
                i /= 2;
            else
                return false;
        } while (i > 2);
        return true;
    }

    private static void addParityBits(List<Integer> values) {
        int index = 1;
        do {
            values.add(index - 1, -1);
            index *= 2;
        } while (index <= values.size());
        for (int i = 1; i < values.size(); i *= 2) {
            values.set(i - 1, defineParityBit(values, i, 0));
        }
    }

    private static Integer defineParityBit(List<Integer> values, int index, int startParityBit) {
        Integer parityBit = startParityBit;
        boolean sheckOrSkip = true;
        for (int i = index - 1; i < values.size(); i += index) {
            if (sheckOrSkip) {
                for (int j = i; j < values.size() && j < i + index; j++) {
                    if (j == index - 1) parityBit = startParityBit;
                    else parityBit = parityBit ^ values.get(j);
                }
                sheckOrSkip = false;
            } else {
                sheckOrSkip = true;
            }
        }
        return parityBit;
    }

}
//0111001110001100000 000001111 0010110 1001011001110101101010 0111100 01111101101011101100110000 1110000 10100001001110 1110011010111111101010010001 001010000101 001010111 0100110100000000111001101110 00011011111001000100000001 1011001101100011101010 00010001000110100111001 111100011011100010100100001 0100001110 00001101010001111010 1101110010010100 11011100001001 00010000001001101001111001 01000101001110000100 00101001000001001111 00010001000 001001110111110010110101 11000001 0001111100101101000000010 1100 011101010011 101101110110011010001 010110100101011111001010 1011000000111101 1010011101000
//0111001110001100000 000001111 0010110 1001011001110101101010 0111100 01111101101011101100110000 1110000 10100001001110 1110011010111111101010010001 001010000101 001010111 0100110100000000111001101110 00011011111001000100000001 1011001101100011101010 00010001000110100111001 111100011011100010100100001 0100001110 00001101010001111010 1101110010010100 11011100001001 00010000001001101001111001 01000101001110000100 00101001000001001111 00010001000 001001110111110010110101 11000001 0001111100101101000000010 1100 011101010011 101101110110011010001 010110100101011111001010 1011000000111101 1010011101000