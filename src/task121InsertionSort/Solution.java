package task121InsertionSort;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        String data =
                "107 57 46 94 176 126 151 67 81 27 4 2 127 149 116 80 84 174 101 35 3 170 22 12 105 90 132 25 98 34 " +
                        "5 60 79 99 37 6 50 103 87 77 88 85 140 178 185 180 156 196 192 61 86 125 184 128 120 189 " +
                        "188 199 138 92 16 36 20 104 32 163 7 144 47 136 108 89 62 194 73 114 113 150 118 131 11 166 " +
                        "190 124 58 175 29 119 96 82 165 19 74 186 68 70 182 122 48 15 161 181 65 147 18 129 191 102 " +
                        "30 109 45 137 59 93 157 146 167 164 106 100 187 23 24 51 172 42";
        String result = "";
        List<Integer> dataArray = Stream.of(data.split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));

        for (int i = 1; i < dataArray.size(); i++) {

            if (dataArray.get(i) > dataArray.get(i - 1)) {
                result += "0 ";
                continue;
            }
            int s = findPlace(dataArray, i);
            result += s + " ";
        }
        System.out.println(result);
    }

    private static int findPlace(List<Integer> dataArray, int indexEnd) {
        int result = 0;
        for (int i = 0; i < indexEnd; i++) {
            if (dataArray.get(i) >= dataArray.get(indexEnd)) {
                swap(dataArray, i, indexEnd);
                result = indexEnd - i;
                break;
            }
        }
        return result;
    }

    private static void swap(List<Integer> dataArray, int i, int indexEnd) {
        dataArray.add(i,dataArray.get(indexEnd));
        dataArray.remove(indexEnd+1);

    }
}