package in28minutes;

import java.util.List;

public class FP03Reduce {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListUseReduce(numbers);
        System.out.println(sum);
        System.out.println("Square every number in a list abd find the sum of squares");
        List<Integer> numbers2 = List.of(1,2,3);
        int res = squareAndFindSum(numbers2);
        System.out.println(res);
    }

    private static int squareAndFindSum(List<Integer> numbers) {

        return numbers.stream().map(num->num*num ).reduce(0,Integer::sum);
    }


    private static int addListUseReduce(List<Integer> numbers) {
        return numbers.stream().reduce(0, FP03Reduce::sum);
    }

    private static int sum(int aggregate, int nextNumber ) {
        return aggregate + nextNumber;
    }


}
