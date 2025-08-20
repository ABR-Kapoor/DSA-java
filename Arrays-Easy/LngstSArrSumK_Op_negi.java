import java.util.HashMap;
import java.util.Map;

public class LngstSArrSumK_Op_negi {
    public static int LngstSArrSum(int[] arr, int k) {
    int sum = 0;
    int maxlen = 0;
    int l = 0;
    int n = arr.length;
    for (int r = 0; r < n; r++) {
        sum += arr[r];
        while (l <= r && sum > k) {
            sum -= arr[l];
            l++;
        }
        if (sum == k) {
            maxlen = Math.max(maxlen, r - l + 1);
        }
    }
    return maxlen;
}
    public static int getLongestSubarray(int []a, int k) {
        int n = a.length; // size of the array.

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(LngstSArrSum(arr, k));
        System.out.println(getLongestSubarray(arr, k));
    }
}
