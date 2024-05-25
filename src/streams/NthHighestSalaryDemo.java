package streams;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalaryDemo {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavana", 1300);
        map1.put("michael", 1500);
        map1.put("tom", 1600);
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("bhavana", 1300);
        map2.put("michael", 1300);
        map2.put("tom", 1600);
        map2.put("ankit", 1200);
        map2.put("daniel", 1700);
        map2.put("james", 1700);
        map2.put("Reshma", 100);


        Map.Entry<Integer, List<String>> nthHighestSalary = getNthHighestSalary(3, map2);

        System.out.println(nthHighestSalary);
    }

    private static Map.Entry<Integer, List<String>> getNthHighestSalary(int num, Map<String, Integer> map) {

        return map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(num - 1);
    }
}
