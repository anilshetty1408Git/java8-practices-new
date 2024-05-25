package in28minutes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraySTartWIthTwo {
    public static void main(String[] args) {
        String input="subsrCibetoinTerviewmania";
        String[] strings = input.split("");
        Map<String, Long> collect = Arrays.stream(strings).map(s -> s.toLowerCase()).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

//        First non repeated character
        Map<String, Long> collect3 = Arrays.stream(strings).map(s -> s.toLowerCase()).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<String, Long> stringLongEntry1 = collect3.entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue() == 1).findFirst().get();
        System.out.println(stringLongEntry1);

        List<String> list = Arrays.asList("anil","anil","akshatha");
        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);
    }
}
