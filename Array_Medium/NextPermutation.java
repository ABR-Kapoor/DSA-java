package Array_Medium;

import java.util.Arrays;

public class NextPermutation {

    public static void f(int[] arr) {
        int n = arr.length;
        int idx = -1;
        for(int i = n-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                idx = i; break;
            }
        }
        if(idx == -1) {
            Arrays.sort(arr);
            return;
        }
        for(int i = n-1; i > idx; i--){
            if(arr[i] > arr[idx]){
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }
        Arrays.sort(arr, idx+1, n);
    }
    public static void main(String[] args) {
        int [] arr = {3,2,1};
        f(arr);
        for (int i : arr) System.out.print(i + " ");
    }
}
