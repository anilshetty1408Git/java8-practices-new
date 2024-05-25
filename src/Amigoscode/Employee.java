package Amigoscode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Employee {
    private int id;
    private String fname;
    private String lastName;
    private double salary;

    public Employee(int id, String fname, String lastName, double salary) {
        this.id = id;
        this.fname = fname;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class MainEmployeeDemo {
    public static void main(String[] args) {
        var employeeList = List.of(
                new Employee(1, "Anil", "Shetty", 25000),
                new Employee(2, "Akshatha", "Shetty", 35000),
                new Employee(3, "John", "Travolta", 15000),
                new Employee(4, "Ramesh", "Prasanna", 45000)

        );
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .filter(employee -> employee.getSalary() > 30000)
                .map(employee->employee.getFname()+" "+employee.getLastName())
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

        System.out.println("-------------------");
        List<String> list = employeeList.stream()
                .filter(employee -> employee.getSalary() > 30000)
                .filter(emploee -> emploee.getFname().startsWith("A"))
                .map(employee -> employee.getFname() + " " + employee.getLastName())
                .sorted(Comparator.naturalOrder())
                .toList();
        System.out.println(list);
    }
}