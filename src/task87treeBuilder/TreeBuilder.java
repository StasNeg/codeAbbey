package task87treeBuilder;


public class TreeBuilder {


    public static void main(String[] args) {
        Node head = new Node();
        String[] data = "15 33 28 16 30 17 10 31 20 8 32 11 27 35 34 24 26 21 9 12 13 6 19 25 4 29 3 2 7 14 1 5 22 18 23".split(" ");
        createTree(head, data);
        System.out.println("(" + printTree(head) + ")");
    }

    private static String printTree(Node head) {
        String result = "";
        Node iterator = head;

        result = "," + iterator.value + ",";
        if (iterator.left != null) {
            result = ("(" + printTree(iterator.left)) + ")" + result;
        }
        if (iterator.right != null) {
            result += ("(" + printTree(iterator.right) + ")");
        }
        if (iterator.right == null && iterator.left == null) {
            result = "-" + result + "-";
        }
        if (iterator.right == null && iterator.left != null) {
            result = result + "-";
        }
        if (iterator.right != null && iterator.left == null) {
            result = "-" + result;
        }
        return result;
    }

    private static void createTree(Node head, String[] data) {
        head.value = Integer.parseInt(data[0]);
        Node iterator = head;
        for (int i = 1; i < data.length; i++) {
            int value = Integer.parseInt(data[i]);
            add(iterator, value);
            iterator = head;

        }
    }

    private static void add(Node node, int value) {
        while (true) {
            if (node.value > value && node.left != null) {
                node = node.left;
                continue;
            }
            if (node.value < value && node.right != null) {
                node = node.right;
                continue;
            }
            if (node.value < value && node.right == null) {
                node.right = new Node(value);
                node.right.parent = node;
                break;
            }
            if (node.value > value && node.left == null) {
                node.left = new Node(value);
                node.left.parent = node;
                break;
            }
        }
    }

    public static class Node {
        private Node parent;
        private Node left;
        private Node right;
        private int value;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            String result = "";
            result += ("parent= " + (parent == null ? "null" : parent.value) + " ");
            result += ("left= " + (left == null ? "null" : left.value) + " ");
            result += ("right= " + (right == null ? "null" : right.value) + " ");
            return "Node{" + result +
                    ", value=" + value +
                    '}';
        }
    }
}
