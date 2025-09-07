package Array_Medium;

public class Kadane_maxSubArray {
    public static int k(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                    if (sum > max)
                        max = sum;
                }
            }
        }
        return max;
    }

    public static int KO(int [] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i =0; i<n; i++){
            sum += arr[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        return max;
    }

    public static int Kb(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int result = k(arr);
        int result2 = Kb(arr);
        int result3 = KO(arr);
        System.out.println("Maximum subarray sum is: " + result3);
        System.out.println("Maximum subarray sum is: " + result);
        System.out.println("Maximum subarray sum is: " + result2);
    }

}
