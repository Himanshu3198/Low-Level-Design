package JavaNotes.practice;

import java.util.Arrays;
import java.util.Collections;

public class ArraysPractice {

    public static void main(String[] args) {
        // Use Integer[] instead of int[] to allow comparator
        Integer[] arr = new Integer[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = (i + 1) * 5;
        }

        // Sort in descending order
        Arrays.sort(arr, Collections.reverseOrder());

        // Print result
        System.out.println(Arrays.toString(arr));

//        Arrays does not support reverse
    }
}
