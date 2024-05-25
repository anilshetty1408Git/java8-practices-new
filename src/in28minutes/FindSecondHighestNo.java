package in28minutes;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindSecondHighestNo {
    public static void main(String[] args) {
        int[] arr = {5, 13, 41, 88, 99, 77};
        Integer integer = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(integer);

        List<Employee> employeeList = Stream.of(
                new Employee(1, "Sumit", "DEV", 5000),
                new Employee(2, "Agam", "DEV", 7000),
                new Employee(3, "Vivek", "QA", 3000),
                new Employee(4, "Nikhil", "QA", 8000),
                new Employee(5, "Jaspreet", "BA", 11000)

        ).toList();

        Map<String, Optional<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
        System.out.println(collect);
    }
}

class Employee {
    private Integer id;
    private String name;
    private String dept;
    private double salary;

    public Employee(Integer id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}