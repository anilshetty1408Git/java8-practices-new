package functionalInterface;

public class MainClass {
    public static void main(String[] args) {
        Calculator calculator = () -> System.out.println("Switch on");
        calculator.switchOn();

        Example2 example2 = (a, b) -> {
            int sum = a + b;
            System.out.println(sum);
        };
        example2.sum(5, 56);

        Substarct substarct = (a, b) -> {
            if (a < b) {
                throw new RuntimeException("Error");
            } else {
                return a - b;
            }
        };
        System.out.println(substarct.substract(8, 9));

    }
}
