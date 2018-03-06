package task136VariableLengthCodeUnpack;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static final Map<String, String> CODE = new HashMap<>();
    static final Node nodeTree;

    static {
        CODE.put("11", " ");
        CODE.put("1001", "t");
        CODE.put("10000", "n");
        CODE.put("0101", "s");
        CODE.put("01000", "r");
        CODE.put("00101", "d");
        CODE.put("001000", "!");
        CODE.put("000101", "c");
        CODE.put("000011", "m");
        CODE.put("0000100", "g");
        CODE.put("0000010", "b");
        CODE.put("00000001", "v");
        CODE.put("0000000001", "k");
        CODE.put("000000000001", "q");
        CODE.put("101", "e");
        CODE.put("10001", "o");
        CODE.put("011", "a");
        CODE.put("01001", "i");
        CODE.put("0011", "h");
        CODE.put("001001", "l");
        CODE.put("00011", "u");
        CODE.put("000100", "f");
        CODE.put("0000101", "p");
        CODE.put("0000011", "w");
        CODE.put("0000001", "y");
        CODE.put("000000001", "j");
        CODE.put("00000000001", "x");
        CODE.put("000000000000", "z");
        nodeTree = createNodeTree();
    }

    private static Node createNodeTree() {
        Node head = new Node();
        for (String key : CODE.keySet()) {
            addKeyToNode(head, key);
        }
        return head;
    }

    private static void addKeyToNode(Node head, String key) {
        Node node = head;
        for (int i = 0; i < key.length(); i++) {
            String current = key.substring(i, i + 1);
            node.next.computeIfAbsent(current, k -> new Node());
            node = node.next.get(current);
        }
    }

    private static class Node {
        private Map<String, Node> next = new HashMap<>();
    }

    public static void main(String[] args) {
        String data = "2OO8A5IJ31GAP0TM3IEGUS1F4TP1CN6U49I08HBJI04GJ5KOD5ES1F2623JPHO5E82OICC2DBMHES1F24P114477H311PSOS2N4125NE0N44O2Q2R0BC4SGMBJAU9N7IEG7DF67IEGUKR4IEMQ3OE5CSII03941SOUH0IHCU9QIHI2M4M83N0BI1M2GL62LA";
        StringBuilder binaryNumber = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            String binaryString = Integer.toBinaryString(Integer.parseInt(data.substring(i, i + 1), 32));
            for (int j = 0; j < 5 - binaryString.length(); j++) {
                binaryNumber.append("0");
            }
            binaryNumber.append(Integer.toBinaryString(Integer.parseInt(data.substring(i, i + 1), 32)));
        }
        Node node = nodeTree;
        StringBuilder result = new StringBuilder();
        int indexBegin = 0;
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (node.next.get(binaryNumber.substring(i, i + 1)) != null) {
                node = node.next.get(binaryNumber.substring(i, i + 1));
            } else {
                node = nodeTree;
                result.append(CODE.get(binaryNumber.substring(indexBegin, i)) == null ? "null" : CODE.get(binaryNumber.substring(indexBegin, i)));
                indexBegin = i;
                i--;
            }
        }
        System.out.println(result.toString());
    }
}
