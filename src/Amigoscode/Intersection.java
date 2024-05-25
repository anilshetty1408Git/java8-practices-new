package Amigoscode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        var list1 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        var list2 = List.of(5, 6, 7, 8);

        Set<Integer> set = new HashSet<>();
        for (Integer integer : list1) {
            set.add(integer);

        }
        for (Integer integer : list2) {
            if (set.contains(integer)) {
                System.out.println(integer);
                break;
            }
        }
    }
}
