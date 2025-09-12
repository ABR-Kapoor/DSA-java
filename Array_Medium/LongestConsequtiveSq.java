package Array_Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveSq {
    public static int b(int [] arr){
        int n = arr.length;
        int longest = 1;
        for (int i =0; i <n; i++){
            int x = arr[i];
            int count = 1;
            while(LinearSearch(arr,x+1)){
                count++; x++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
    public static boolean LinearSearch(int [] arr, int x){
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]==x) return true;
        }
        return false;
    }
    public static int better(int [] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int longest = 1;
        int c =0;
        int lastSmall = Integer.MIN_VALUE;

        for (int i =0; i <n; i++){
            if(arr[i]-1 == lastSmall){
                c++; lastSmall= arr[i];
            } else if(arr[i] != lastSmall){
                c=1; lastSmall = arr[i];
            }
            longest = Math.max(longest, c);
        }
        return longest;
    }

    public static int Opti(int [] arr){        
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : arr) set.add(num);
        for(int num : arr){
            if(!set.contains(num-1)){
                int cnt = 1;
                int x = num;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int [] arr = {102,4,100,1,101,3,2,1,1};
        System.out.println(b(arr));
        System.out.println(better(arr));
        System.out.println(Opti(arr));
    }
}