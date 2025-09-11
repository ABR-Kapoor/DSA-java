package Array_Medium;

import java.util.ArrayList;

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
    public static void main(String[] args) {
        int [] arr = {10,22,12,3,0,6};
        ArrayList<Integer> leaders = B(arr);
        for (int leader : leaders) {
            System.out.print(leader + " ");
        }
    }
}