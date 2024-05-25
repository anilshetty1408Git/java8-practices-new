package intervies;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStreamDemo {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        employeeList.add(new Employee(1, "John Doe", 30, "Male", "Sales", 2010, 50000.0));
        employeeList.add(new Employee(2, "Jane Smith", 35, "Female", "Marketing", 2012, 60000.0));
        employeeList.add(new Employee(3, "Michael Johnson", 28, "Male", "IT", 2015, 55000.0));
        employeeList.add(new Employee(4, "Emily Davis", 32, "Male", "Finance", 2011, 70000.0));
        employeeList.add(new Employee(5, "Robert Wilson", 40, "Male", "Operations", 2008, 75000.0));
        employeeList.add(new Employee(6, "Sophia Brown", 27, "Female", "HR", 2017, 45000.0));
        employeeList.add(new Employee(7, "David Anderson", 33, "Male", "Sales", 2009, 55000.0));
        employeeList.add(new Employee(8, "Olivia Martinez", 31, "Female", "Marketing", 2013, 65000.0));
        employeeList.add(new Employee(9, "James Taylor", 29, "Male", "IT", 2014, 60000.0));
        employeeList.add(new Employee(10, "Ava Thomas", 34, "Female", "Finance", 2016, 70000.0));
        employeeList.add(new Employee(11, "Daniel Robinson", 36, "Male", "Operations", 2007, 80000.0));
        employeeList.add(new Employee(12, "Mia Hernandez", 26, "Female", "HR", 2018, 50000.0));
        employeeList.add(new Employee(13, "William Lee", 31, "Male", "Sales", 2009, 60000.0));
        employeeList.add(new Employee(14, "Sofia Clark", 32, "Female", "Marketing", 2011, 70000.0));
        employeeList.add(new Employee(15, "Benjamin Lewis", 29, "Male", "IT", 2014, 55000.0));
        employeeList.add(new Employee(16, "Avery Rodriguez", 33, "Female", "Finance", 2010, 65000.0));
        employeeList.add(new Employee(17, "Elijah Walker", 38, "Male", "Operations", 2006, 80000.0));
        employeeList.add(new Employee(18, "Scarlett Wright", 25, "Female", "HR", 2019, 45000.0));
        employeeList.add(new Employee(19, "Logan Hall", 27, "Male", "Sales", 2016, 55000.0));
        employeeList.add(new Employee(20, "Lily Green", 30, "Female", "Marketing", 2013, 60000.0));

//       How many male and female employees in the organization
        method1();

//       Print the name of all departments in organization
        method2();
//        What is the average age of male and female employees.
        method3();
//        Get the highest paid in org
        method4();

//      Get the names of all employees who have joined after 2015
        method5();
//      Count the no of employees in each department
        method6();
//      What is the average salary of each department
        method7();
//        Get the details of youngest male employee in the Finance department
        method8();

        method9();
//        Find salary and dept and add bonus 10000
    }

    private static void method9() {
        Stream<Double> doubleStream = employeeList.stream()
                .filter(employee -> employee.getSalary() > 50000 && employee.getDepartment().equals("Finance"))
                .map(employee -> employee.getSalary() + 10000);
        System.out.println("after bonus: "+doubleStream.collect(Collectors.toList()));
    }

    private static void method8() {
        System.out.println(" Get the details of youngest male employee in the Finance department");
        Optional<Employee> youngMale = employeeList.stream()
                .filter(e -> e.getGender().equals("Male") && e.getDepartment().equals("Finance")).min(Comparator.comparing(Employee::getAge));
        System.out.println(youngMale);
    }

    private static void method7() {
        System.out.println(" What is the average salary of each department");
        Map<String, Double> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        collect.forEach((department, salary) -> {
            System.out.println(department + "::::::" + salary);
        });
    }

    private static void method6() {
        System.out.println("Count the no of employees in each department");
        Map<String, Long> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        collect.entrySet().stream().forEach(emp-> System.out.println(emp.getKey()+" "+emp.getValue()));


        for (Map.Entry<String, Long> entry : collect.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
//          Similar approach
            System.out.println("Another approach");
        }
        collect.forEach((department, count) -> {
            System.out.println(department + "::" + count);
        });
    }

    private static void method5() {
        System.out.println("Get the names of all employees who have joined after 2015");
        employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
    }

    private static void method4() {
        System.out.println("Get the highest paid in org");
        Optional<Employee> highstSal = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(highstSal.get().getName());
    }

    private static void method3() {
        System.out.println(" What is the average age of male and female employees.");
        Map<String, Double> averageAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(averageAge);
    }

    private static void method2() {
        System.out.println("Print the name of all departments in organization");
        employeeList.stream()
                .map(Employee::getDepartment).distinct().forEach(System.out::println);

    }

    private static void method1() {
        System.out.println("Query 1 : How many male and female employees in the organization");
        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);
    }
}
