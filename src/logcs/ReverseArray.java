package logcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 15, 78};
        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            reversed[i] = arr[arr.length - 1 - i];

        }
        System.out.println(Arrays.toString(reversed));



    }
}
