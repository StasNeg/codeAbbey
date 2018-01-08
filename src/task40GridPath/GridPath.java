package task40GridPath;

public class GridPath {

    static final int ROW = 16;
    static final int COL = 18;
    static private String[] input =
//
//            {"@ + + + +",
//                    "+ + + X X",
//                    "+ X + + +",
//                    "+ + + X +",
//                    "+ X + + X",
//                    "+ + + + $"};


                    {"@ + + + + + + + + + + + + + + + + +",
                    "+ + + + + X + + + + + + + + + + + +",
                    "+ + + X + + + + + + + + X + + + + X",
                    "+ + + + + + + + + + + + + + + + + +",
                    "+ + + + + + + + + + + + + + + + + +",
                    "+ + + + + + + X + + + X + + X + + X",
                    "+ + + X + + + + X + + + + + + + + X",
                    "+ X X + + + + + + + + X + X + + + +",
                    "+ + + + + X X + + + + + + + + + + +",
                    "+ + X X + + X X + X + + X + + + + +",
                    "+ + + + + + + + + + + + + + X + X +",
                    "+ + + + X + + X + + + + + + + + + +",
                    "+ + + + + + + + + + + + + + + + + +",
                    "+ + + + + + + X + + + + + + X + X +",
                    "+ X + + X X + + + + + X + + + + + +",
                    "+ X + + + + + + + + + + + X + + + $"};

    static String grid[][] = new String[ROW][COL];

    static {
        for (int i = 0; i < input.length; i++) {
            String[] splitted = input[i].split(" ");
            for (int j = 0; j < splitted.length; j++) {
                grid[i][j] = splitted[j];
            }
        }

    }

    public static void main(String[] args) {
        Node[] nodes = createNodes(grid);
        clearNodes(nodes);
        routCount(nodes);
        System.out.println(nodes[ROW * COL - 1].countPass);
    }


    private static void routCount(Node[] nodes) {
        nodes[0].countPass = 1;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].right != null)
                nodes[i].right.countPass += nodes[i].countPass;
            if (nodes[i].down != null)
                nodes[i].down.countPass += nodes[i].countPass;
        }
    }


    private static void clearNodes(Node[] nodes) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].right != null && nodes[i].right.value == -1) {
                nodes[i].right = null;
            }
            if (nodes[i].down != null && nodes[i].down.value == -1) {
                nodes[i].down = null;
            }
        }
    }

    private static Node[] createNodes(String[][] grid) {
        Node[] result = new Node[ROW * COL];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Node();
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if ("X".equals(grid[i][j])) {
                    result[i * COL + j].value = -1;
                    continue;
                }
                result[i * COL + j].value = i * COL + j;
//                first left
                if (i == 0 && j == 0) {
                    result[i * COL + j].right = result[i * COL + j + 1];
                    result[i * COL + j].down = result[i * COL + j + COL];
                    continue;
                }
//                first right
                if (i == 0 && j == COL - 1) {
                    result[i * COL + j].down = result[i * COL + j + COL];
                    continue;
                }
//                last right
                if (i == ROW - 1 && j == COL - 1) {
                    continue;
                }
//                last left
                if (i == ROW - 1 && j == 0) {
                    result[i * COL + j].right = result[i * COL + j + 1];
                    continue;
                }
//                last average
                if (i == ROW - 1 && j != 0 && j != COL - 1) {
                    result[i * COL + j].right = result[i * COL + j + 1];
                    continue;
                }
//                first row average
                if (i == 0 && j != 0) {
                    result[i * COL + j].right = result[i * COL + j + 1];
                    result[i * COL + j].down = result[i * COL + j + COL];
                    continue;
                }
//                first column average
                if (i != 0 && j == 0) {
                    result[i * COL + j].right = result[i * COL + j + 1];
                    result[i * COL + j].down = result[i * COL + j + COL];
                    continue;
                }
//                last column average
                if (i != 0 && j == COL - 1) {
                    result[i * COL + j].down = result[i * COL + j + COL];
                    continue;
                }
//                inside
                result[i * COL + j].right = result[i * COL + j + 1];

                result[i * COL + j].down = result[i * COL + j + COL];

            }
        }
        return result;
    }

    public static class Node {

        Node down;
        Node right;
        int value;
        int countPass;

        @Override
        public String toString() {
            String returned = "[";
            returned += "down=" + (down == null ? "null" : down.value);
            returned += ", right=" + (right == null ? "null" : right.value);
            returned += ", value=" + value;
            returned += ", countPass=" + countPass + "]";
            return returned;
        }
    }
}
