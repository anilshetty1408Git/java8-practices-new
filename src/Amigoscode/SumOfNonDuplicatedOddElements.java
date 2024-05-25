package Amigoscode;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumOfNonDuplicatedOddElements {
    public static void main(String[] args) {
        var list = List.of(1, 1, 2, 2, 43, 3, 3, 3, 4, 4, 3, 3, 3, 39, 6, 0);
        List<Map.Entry<Integer, Long>> list1 = list.stream()
                .filter(integer -> integer % 2 != 0)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(key -> key.getValue() <= 1)
                .toList();
        System.out.println(list1);

    }

}
