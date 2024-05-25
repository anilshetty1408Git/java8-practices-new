package in28minutes;

import java.util.List;

public class FP01Structure {
    public static void main(String[] args) {
        printAllNumbersInJavaStructured(List.of(12, 9, 13, 4, 6, 2, 4, 12, 15));
    }

    private static void printAllNumbersInJavaStructured(List<Integer> numbers) {
//         How to loop the numbers
        for (int number : numbers) {
            System.out.print(" "+number);

        }
    }
}
