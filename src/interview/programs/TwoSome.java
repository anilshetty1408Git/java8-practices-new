package interview.programs;

import java.util.HashMap;
import java.util.Map;

public class TwoSome {
    public static void main(String[] args) {
        // input {2,7,11,15},target = 7

        int arr[] = {3, 5, 2, -4, 8, 11};
        int target = 7;
        var map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = target-arr[i]; // 7,2
            if (map.containsKey(diff)){
                System.out.println(map.get(diff)+"--"+i);
            }
            map.put(arr[i], i); // 0,2
        }
    }
}
