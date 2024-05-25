package in28minutes;

import java.util.Arrays;
import java.util.List;

public class Exercises01 {
    public static void main(String[] args) {
//     Print only Odd numbers from the list
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printOddNumberInList(numbers);
        System.out.println("-----");
//     Print all Courses indivisually
       List<String> list = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
       printAllCourseIndivisually(list);
        System.out.println("-----");
//     Print courses containing word Spring
       printCourseContainingSpring(list);
        System.out.println("-----");
//     Print course whose name has at least 4 letters
       printCourseNAmeHas4Digit(list);


    }

    private static void printCourseNAmeHas4Digit(List<String> list) {
        list.stream().filter(s->s.length()>=4).forEach(System.out::println);
    }

    private static void printCourseContainingSpring(List<String> list) {
        list.stream().filter(s -> s.contains("Spring")).forEach(System.out::println);
    }

    private static void printAllCourseIndivisually(List<String> list) {
        list.stream().forEach(System.out::println);
    }

    private static void printOddNumberInList(List<Integer> numbers) {
        numbers.stream().filter(num->num%2!=0).forEach(System.out::println);
    }
}
