package mischaklleneous;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicatesInList {
    public static void main(String[] args) {
        var list = Arrays.asList(1, 2, 3, 5, 8, 6, 1, 2, 3, 7);
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
        int arr[] = {1, 2, 3, 4, 2, 5, 5};
        IntStream.of(arr).distinct().forEach(System.out::println);
        String string = "javatttttttpoint";
        String res = string.replaceAll("t", "m");
        System.out.println(res);

        char ch[] = string.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 't') {
                ch[i] = 'm';
            }
        }
        System.out.println(Arrays.toString(ch));

//        Compile error, Parent class declared first here then the child

        /*try {
            int i = 10 / 0;
            System.out.println("in try block");
        } catch (RuntimeException e) {
            System.out.println("Exception block");
        } catch (ArithmeticException a) {
            System.out.println("Arithmetuc ex");
        } finally {
            System.out.println("finally block");
        }*/
        String s = "apple";
        String[] split = s.split("");
        Arrays.stream(split).distinct().forEach(System.out::println);
        Map<String, Long> collect1 = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);
        collect1.entrySet().stream().filter(a->a.getValue()==1).forEach(key-> System.out.print(key.getKey()+" "));
    }
}
