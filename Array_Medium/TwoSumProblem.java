package Array_Medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {
    public static int[] f(int [] arr, int target){
        int n = arr.length;
        for(int i = 0 ; i < n; i++){
            for (int j = i+1; j < n; j++){
                // if (arr[i] == arr[j]) return new int[]{i,j};
                if(arr[i] + arr[j] == target) return new int[]{i,j};
                if(arr[i] + arr[j] == target && arr[i] == arr[j]) return new int[]{i,j};
            }
        }
        return null;
    }
    public static int[] btF(int [] arr, int target){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            int num = arr[j];
            int need = target - num;
            if (map.containsKey(need)) {
                return new int[]{map.get(need), j};
            }
            map.put(num, j);
        }
        return null;
    }
    public static boolean OptF(int [] arr, int target){
        int left = 0;
        int right = arr.length- 1;
        Arrays.sort(arr);
        while (left < right){
            int sum = arr[left] + arr[right];
            if(sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false; 
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1};
        int target = 11;
        int[] result = btF(arr, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}
