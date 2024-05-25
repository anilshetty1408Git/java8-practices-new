package in28minutes;

import java.util.Arrays;
import java.util.List;

public class FP02FunctionalMap {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printSuareNumberInList(numbers);
        System.out.println("---------------");
        printQubesOffOddNumbers(numbers);
        System.out.println("----------------------");
        List<String> list = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printNoOfCharacterInEachCourse(list);
    }

    private static void printNoOfCharacterInEachCourse(List<String> list) {
        list.stream().map(str->str+" "+str.length()).forEach(System.out::println);
    }

    private static void printQubesOffOddNumbers(List<Integer> numbers) {
        numbers.stream().filter(num->num%2!=0).map(num->num*num*num).forEach(System.out::println);
    }

    private static void printSuareNumberInList(List<Integer> numbers) {
        numbers.stream().map(num->num*num).forEach(System.out::println);
    }

}
