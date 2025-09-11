package Array_Medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderInAnArray{
    public static ArrayList<Integer> B(int [] arr){
        int n = arr.length;
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) isLeader = false;
            }
            if (isLeader) ansList.add(arr[i]);
        }
        return ansList;
    }
    public static ArrayList<Integer> Op(int [] arr){
        int n = arr.length;
        ArrayList <Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n-1; i >=0; i--) {
            if(arr[i] >= max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        int [] arr = {61,61,17};
        ArrayList<Integer> leaders = B(arr);
        ArrayList<Integer> optimizedLeaders = Op(arr);
        System.out.println("Leaders in the array (Brute Force):");
        for (int leader : leaders) {
            System.out.print(leader + " ");
        }
        System.out.println("\nLeaders in the array (Optimized):");
        for (int leader : optimizedLeaders) {
            System.out.print(leader + " ");
        }
    }
}