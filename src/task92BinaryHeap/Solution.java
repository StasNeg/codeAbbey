package task92BinaryHeap;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String data = "7 28 31 0 25 26 0 22 30 6 12 3 0 8 2 0 14 15 0 10 0 13 0 19 1 9 35 34 5 29 33 0 4 0 24 0 16 36 11 0 32 0 18 0 27 17 23 21 20";
        List<Integer> binaryHeap = new ArrayList<>();
        for (String s : data.split(" ")) {
            int number = Integer.parseInt(s);
            if (number == 0) {
                deleteFromBinaryHeap(binaryHeap);
            } else {
                addtoBinaryHeap(binaryHeap, number);
            }
        }
        for (Integer i : binaryHeap) {

            System.out.println(i + " ");
        }
    }

    private static void deleteFromBinaryHeap(List<Integer> binaryHeap) {
        int removed = binaryHeap.remove(binaryHeap.size() - 1);
        binaryHeap.set(0, removed);
        int size = binaryHeap.size();
        for (int i = 0; i < size; ) {
            int leftChildren = Integer.MAX_VALUE;
            int rightChildren = Integer.MAX_VALUE;
            if (2 * i + 1 < size) {
                leftChildren = binaryHeap.get(2 * i + 1);
            }
            if (2 * i + 2 < size) {
                rightChildren = binaryHeap.get(2 * i + 2);
            }
            int current = binaryHeap.get(i);
            if (current > leftChildren && current > rightChildren) {
                if (leftChildren > rightChildren) {
                    swapBinary(binaryHeap, i, 2 * i + 2);
                    i = 2 * i + 2;
                } else {
                    swapBinary(binaryHeap, i, 2 * i + 1);
                    i = 2 * i + 1;
                }
            } else if (current > leftChildren) {
                swapBinary(binaryHeap, i, 2 * i + 1);
                i = 2 * i + 1;
            } else if (current > rightChildren) {
                swapBinary(binaryHeap, i, 2 * i + 2);
                i = 2 * i + 2;
            } else break;
        }
    }

    private static void swapBinary(List<Integer> binaryHeap, int curent, int swaapped) {
        int temp = binaryHeap.get(swaapped);
        binaryHeap.set(swaapped, binaryHeap.get(curent));
        binaryHeap.set(curent, temp);
    }

    private static void addtoBinaryHeap(List<Integer> binaryHeap, int number) {
        binaryHeap.add(number);
        for (int i = binaryHeap.size() - 1; i >= 0; ) {
            int indexParent = (i - 1) / 2;
            if (number < binaryHeap.get(indexParent)) {
                swapBinary(binaryHeap, i, indexParent);
                i = indexParent;
            } else {
                break;
            }
        }
    }
}
