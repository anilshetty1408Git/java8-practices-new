package in28minutes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> collect = listOfLists.stream().flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println(collect);


        int[] arr ={1,2,3,4,5,6,1};
        int[] array = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(array));
        List<int[]> list = Arrays.asList(arr);
        Stream<String> stream = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().map(key -> key.getKey() + "-" + key.getValue());
    }

}
