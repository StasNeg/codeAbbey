package task156LuhnAlgorithm;

public class Solution {
    public static void main(String[] args) {
        String[] data = {
                "?908844474218755",
                "9532677866570033",
                "?482724419170294",
                "600271025425?245",
                "7153910052093838",
                "1399222940003400",
                "7402541109611634",
                "24409379746?0705",
                "5102703541126290",
                "?063686513794020",
                "5037985377621977",
                "1494701?73292777",
                "82256419331472?5",
                "4?11910448966451",
                "2169354777543591",
                "4385693512?11310",
                "919967?899085657",
                "700523403802?664",
                "5748242937?43880",
                "?315853907079764",
                "8481882199425269",
                "861549573?541452",
                "8793851632?34034",
                "8550390206988014",
                "43170?7653001571",
                "13?7977074320254",
                "?849131183628052",
                "632063835766?815",
                "7918350107244851",
                "9217174602891610",
                "5452963514972980",
                "75935844?3612830",
                "6819236885871118",
                "84?9462954820735",
                "1513928583307159",
                "1900875939496415",
                "2778070813216?78",
                "90904494763?1379",
                "5058196011045099",
                "4634916298329021",
                "8306535942395638",
                "2638750041134?05",
                "2085675411509387",
                "4413307008265818"
        };
        String result = "";
        for (String number : data) {
            if (number.contains("?")) {
                result += findOneNumber(number) + " ";
            } else {
                result += findSwapNumder(number) + " ";
            }
        }
        System.out.println(result);
    }

    private static String findOneNumber(String data) {
        int RADIX = 10;
        char[] numbers = data.toCharArray();
        int index = -1;
        int sum = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == '?') {
                index = i;
            } else {
                if (i % 2 == 0) {
                    int number = 2 * Character.getNumericValue(numbers[i]) > 9 ? 2 * Character.getNumericValue(numbers[i]) - 9 : 2 * Character.getNumericValue(numbers[i]);
                    sum += number;
                } else {
                    sum += Character.getNumericValue(numbers[i]);
                }
            }
        }
        int rest = 10 - sum % 10;
        char ch;
        if (rest == 10) {
            ch = '0';
        } else if (index % 2 == 0) {
            ch = rest % 2 == 0 ? Character.forDigit(rest / 2, RADIX) : Character.forDigit((rest + 9) / 2, RADIX);
        } else {
            ch = Character.forDigit(rest, RADIX);
        }
        numbers[index] = ch;
        return new String(numbers);
    }

    private static String findSwapNumder(String data) {

        char[] numbers = data.toCharArray();
        for (int i = 0; i < numbers.length - 1; i++) {
            char[] clone = numbers.clone();
            if (checkSum(swap(clone, i))) {
                return new String(clone);
            }
        }
        return new String();
    }

    private static char[] swap(char[] clone, int i) {
        char temp = clone[i];
        clone[i] = clone[i + 1];
        clone[i + 1] = temp;
        return clone;
    }

    private static boolean checkSum(char[] numbers) {
        int sum = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                int number = 2 * Character.getNumericValue(numbers[i]) > 9 ? 2 * Character.getNumericValue(numbers[i]) - 9 : 2 * Character.getNumericValue(numbers[i]);
                sum += number;
            } else {
                sum += Character.getNumericValue(numbers[i]);
            }
        }
        return sum % 10 == 0;
    }
//5881809177868152 8868320798531766 9970868907414020 2008209596001821 4719312018939762 1449065260769203 8016309379009335 8473564403767375 1858153599338421 2263184931447452 5217129306147476 5714226287374158 5796642738766357 6743931118564512 8960860940982497 9394465547975342 3343057050276070 9478070287578527 6670885949950729 7927140195966352 1033537371434069 2066096885892245 3077394941691056 7197281217008279 5982819399834674 3069013276745218 8827284426951186 6911399831252839 1717814670800016 3853672948623762 4065859211729416 6775485592008067 4033683050921473 4016432944943090 9031151426073636 4141132546919013 7080494795667743 8017249408306469 4721769865335558
//5881809177868152 8868320798531766 9970868907414020 2008209596001821 4719312018939762 1449065260769203 8016309379009335 8473564403767375 1858153599338421 2263184931447452 5217129306147476 5714226287374158 5796642738766357 6743931118564512 8960860940982497 9394465547975342 3343057050276070 9478070287578527 6670885949950729 7927140195966352 1033537371434069 2066096885892245 3077394941691056 7197281217008279 5982819399834674 3069013276745218 8827284426951186 1717814670800016 3853672948623762 4065859211729416 6775485592008067 4033683050921473 4016432944943090 9031151426073636 4141132546919013 7080494795667743 8017249408306469 4721769865335558
}
