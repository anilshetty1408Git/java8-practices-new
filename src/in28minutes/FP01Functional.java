package in28minutes;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInJavaFuctional(numbers);
        printEvenNumberInList(numbers);
    }

    private static void printEvenNumberInList(List<Integer> numbers) {
        System.out.println("Print all even numbers");
        numbers.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
    }

    private static void printAllNumbersInJavaFuctional(List<Integer> numbers) {

        System.out.println("How to loop the numbers");
        numbers.stream().forEach(FP01Functional::print);
    }

    private static void print(Integer integer) {
        System.out.print(integer + " ");
    }


}
