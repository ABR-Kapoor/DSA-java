package Array_Medium;
import java.util.*;
class Solution {
    public int subarraySum(int[] arr, int k) {
    int sum = 0;
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // To handle the case when subarray starts from index 0

    for (int num : arr) {
        sum += num;
        if (map.containsKey(sum - k)) {
            count += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
}
}

public class CountSArrSum {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,6,4,3,2};
        Solution sol = new Solution();
        System.out.println(sol.subarraySum(a, 12));
    }
    
}
