package task131FourPicsOneWord;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Stanislav on 03.03.2018.
 */
public class Permutation {
        /* arr[]  ---> Input Array
        data[] ---> Temporary array to store current combination
        start & end ---> Staring and Ending indexes in arr[]
        index  ---> Current index in data[]
        r ---> Size of a combination to be printed */
        public static Set<String> words = new HashSet<>();

        static void combinationUtil(char arr[], char data[], int start,
                                    int end, int index, int r)
        {
            // Current combination is ready to be printed, print it
            if (index == r)
            {
                StringBuilder res = new StringBuilder();
                for (int j=0; j<r; j++)
                    res.append(data[j]);
                words.add(res.toString());
                return;
            }

            // replace index with all possible elements. The condition
            // "end-i+1 >= r-index" makes sure that including one element
            // at index will make a combination with remaining elements
            // at remaining positions
            for (int i=start; i<=end && end-i+1 >= r-index; i++)
            {
                data[index] = arr[i];
                combinationUtil(arr, data, i+1, end, index+1, r);
            }
        }

        // The main function that prints all combinations of size r
        // in arr[] of size n. This function mainly uses combinationUtil()
        static void printCombination(char arr[], int n, int r)
        {
            // A temporary array to store all combination one by one
            char data[]=new char[r];

            // Print all combination using temprary array 'data[]'
            combinationUtil(arr, data, 0, n-1, 0, r);
        }

        /*Driver function to check for above function*/
        public static void main (String[] args) {
            char arr[] = {'a','b', 'c', 'd', 'e', 'f'};
            int r = 3;
            int n = arr.length;
            printCombination(arr, n, r);
        }

}
