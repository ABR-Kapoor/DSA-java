package Array_Medium;

public class Kadane_reThatSubArray {
    public static int[] KO(int [] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start =-1;
        int end =-1;
        for (int i =0; i<n; i++){
            if (sum ==0) start = i;
            sum += arr[i];
            if (sum > max) { max = sum; end =i; }
            if (sum < 0) sum = 0;
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-2,5 };
        int [] result3 = KO(arr);
        System.out.println("Maximum subarray sum is: " + result3[0] + " to " + result3[1]);
    }
}
