package drunkenengineer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Interview {
    public static void main(String[] args) {
//        Create list to map
        Map<String, List<DrunkenEmployee>> collect = createEmpList().stream().collect(Collectors.groupingBy(DrunkenEmployee::getCity));
        collect.forEach((key, value) -> System.out.println(key+"-"+value));

    }

    private static List<DrunkenEmployee> createEmpList() {
        var list = List.of(
                new DrunkenEmployee("Arun", "1", "Hyderabad"),
                new DrunkenEmployee("Mahesh", "2", "Noida"),
                new DrunkenEmployee("Vijay", "3", "Pune"),
                new DrunkenEmployee("Lakshman", "4", "Bangalore"),
                new DrunkenEmployee("Kalyan", "5", "Bangalore")
        );
        return list;

    }
}
