package task122QuickSort;


public class Solution {
    public static void main(String[] args) {
        String data = "19 119 46 185 115 77 183 71 32 96 100 113 16 179 18 114 84 43 197 136 132 111 13 86 30 116 138 164 21 88 70 48 146 31 10 50 17 196 99 58 147 26 174 61 60 141 76 128 24 181 63 168 82 73 59 40 186 29 109 133 117 65 35 68 139 53 41 33 142 188 120 180 192 163 52 93 15 118 140 7 107 157 189 161 78 195 123 98 62 162 11 122 160 176 110 79 6 155 143 42 45 158 144 34 23 153 20 125 127 85 134 178 105 27 47 89 108 124 4 199 57 92 151 55";
        String[] arrayNumberFromData = data.split(" ");
        int[] numbers = new int[arrayNumberFromData.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(arrayNumberFromData[i]);
        }
        quicksort(numbers, 0, numbers.length - 1);
    }

    private static void quicksort(int[] array, int left, int right) {
        int pivot_pos = partition(array, left, right);
        System.out.print(left + "-" + right + " ");
        if (pivot_pos - left > 1) {
            quicksort(array, left, pivot_pos - 1);
        }
        if (right - pivot_pos > 1) {
            quicksort(array, pivot_pos + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int lt = left;
        int rt = right;
        String dir = "left"; //       #specifies at which side is currently "empty" space
        int pivot = array[left];
        while (lt < rt) {
            if (dir.equals("left")) {
                if (array[rt] > pivot) {
                    rt = rt - 1;
                } else {
                    array[lt] = array[rt];
                    lt = lt + 1;
                    dir = "right";
                }
            } else {
                if (array[lt] < pivot) {
                    lt = lt + 1;
                } else {
                    array[rt] = array[lt];
                    rt = rt - 1;
                    dir = "left";
                }
            }
        }
        array[lt] = pivot;//     #here lt = rt - both points to empty cell where pivot should return
        return lt;
    }

}
