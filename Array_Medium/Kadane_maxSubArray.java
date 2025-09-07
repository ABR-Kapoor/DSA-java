package Array_Medium;

public class Kadane_maxSubArray {
    public static int k(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += arr[k];
                }
                if(sum > max) max = sum;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = k(arr);
        System.out.println("Maximum subarray sum is: " + result);
    }
    
}
