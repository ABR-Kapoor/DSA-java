import java.util.HashMap;
import java.util.Map;

public class LngstSArrSumK_posi {
    public static int longestSubarray(int[] arr, int k) {
        int maxlen = 0; 
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum == k) maxlen = Math.max(maxlen, i+1);
            int rem = sum - k;
            if (map.containsKey(rem)){
                int len = i - map.get(rem);
                maxlen = Math.max(maxlen, len);
            }
            if(!map.containsKey(rem)){
                map.put(sum, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1,1,1,1};
        int k = 5;
        System.out.println(longestSubarray(arr, k));
    }
}
