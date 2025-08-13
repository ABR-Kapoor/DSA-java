import java.util.ArrayList;

public class IntersactionSortedArr {
    public static ArrayList<Integer> intersaction(int []a, int [] b){
        int n1 = a.length;
        int n2 = b.length;
        int[] visited = new int[n2];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i< n1; i++){
            for(int j =0; j<n2; j++){
                if (a[i] == b[j] && visited[j] == 0){
                    ans.add(a[i]);
                    visited[j] = 1;
                    break;
                }
                if (a[i] < b[j]) break;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> OptiIntersection(int [] a, int[]b){
        int i=0;
        int j=0;
        int n1 = a.length;
        int n2 = b.length;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n1 && j < n2){
            if (a[i] < b[j]) i++;
            else if (a[i] > b[j]) j++;
            else {
                ans.add(a[i]);
                i++;j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        ArrayList<Integer> result = OptiIntersection(arr1, arr2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
