package mischaklleneous;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
//        create a list of integer values.
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Original list: " + myList);
//        Obtain stream to array list
        Stream<Integer> myStream = myList.stream();
//        Obtain the minimum and maximum by use of min(),max(),isPresent() and get()
        Optional<Integer> minVal = myStream.min(Integer::compare);
        if (minVal.isPresent()) {
            System.out.println("Minimum value is :" + minVal.get());
        }
//        Must obtain a new stream because previous call to min() is terminal operation that consumed the stream.

        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if (maxVal.isPresent()) {
            System.out.println("Max is present :" + maxVal.get());
        }
//        sort the stream by use of sorted().
        Stream<Integer> sortedStream = myList.stream().sorted();

//        Display the sorted stream by ise of forEach().
        sortedStream.forEach(n -> System.out.print(n + " "));
        System.out.println();

//        Display only odd values by use of filter()
        Stream<Integer> oddVals = myList.stream().sorted().filter(n -> n % 2 == 1);
        System.out.println("Odd values: ");
        oddVals.forEach(n -> System.out.print(n + " "));
        System.out.println();

//        Display only odd calues that are greater than 5. notice that two filter operations are pipelined.
        oddVals = myList.stream().filter(n -> n % 2 == 1).filter(n -> n > 5);
        System.out.println("Odd values greater than 5 : ");
        oddVals.forEach(n -> System.out.print(n + " "));
        System.out.println();

//        Reduce operations: Two ways to obtain the integer product of the elements in myList to use reduce()
        Optional<Integer> prodObj = myList.stream().reduce((a, b) -> a * b);
        if (prodObj.isPresent()) {
            System.out.println("Product as optional: " + prodObj.get());
        }
        int product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product as int: " + product);

        Optional<Integer> sum = myList.stream().reduce((a, b) -> a + b);
        if (sum.isPresent()) {
            System.out.println(sum.get());
        }
//        Parallel stream
        Double parallelRes = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println("parallel stream "+parallelRes);

        Double mapReduceRes = myList.stream().map(a -> Math.sqrt(a)).reduce(1.0, (a, b) -> a * b);
        System.out.println(mapReduceRes);
    }
}
