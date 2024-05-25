package in28minutes;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04CustomClass {
    public static void main(String[] args) {
        var courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 20000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );
//        allMatch,noneMatch,anyMatch
        System.out.println("allMatch,noneMatch,anyMatch");
        Predicate<Course> courseGreater90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> courseGreater95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> courseLess90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(courseGreater95Predicate));
        System.out.println(courses.stream().noneMatch(courseLess90Predicate));
        System.out.println(courses.stream().anyMatch(courseLess90Predicate));
        System.out.println(courses.stream().anyMatch(courseGreater90Predicate));

        System.out.println("Comparator");
        Comparator<Course> comparingByNoOfStudentsAsc = Comparator.comparingInt(Course::getNoOdStudents);
        Comparator<Course> comparingByNoOfStudentsDesc = Comparator.comparingInt(Course::getNoOdStudents).reversed();
        Comparator<Course> comparaingByHighestReviewFirstSameStudents = Comparator.comparingInt(Course::getNoOdStudents)
                .thenComparingInt(Course::getReviewScore).reversed();



        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAsc)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsDesc)
                .collect(Collectors.toList()));

        System.out.println(courses.stream().sorted(comparaingByHighestReviewFirstSameStudents).collect(Collectors.toList()));

        System.out.println("--------------------");
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));
        Map<String, Long> collect = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        System.out.println(collect);
        Map<String, Optional<Course>> collect1 = courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore))));
        System.out.println(collect1);

        System.out.println("Group by Category name");
        Map<String, List<String>> collect2 = courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())));

        System.out.println(collect2);

    }
}

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOdStudents;

    public Course(String name, String category, int reviewScore, int noOdStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOdStudents = noOdStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOdStudents() {
        return noOdStudents;
    }

    public void setNoOdStudents(int noOdStudents) {
        this.noOdStudents = noOdStudents;
    }

    public String toString() {
        return name + ":" + noOdStudents + ":" + reviewScore;
    }
}
