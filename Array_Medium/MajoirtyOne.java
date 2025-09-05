package Array_Medium;

import java.util.HashMap;
import java.util.Map;

public class MajoirtyOne {
    public static int majority(int [] arr){
        int n = arr.length;
        for (int i = 0; i<n; i++){
            int c = 0;
            for(int j = 0; j<n; j++){
                if(arr[i]==arr[j]) c++;
            }
            if(c > n/2) return arr[i];
        }
        return -1;
    }
    public static int Better(int [] arr){
        int n = arr.length;
        Map <Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
            if (m.get(arr[i]) > n / 2) return arr[i];
        }
        return -1;
    }

    public static int Opti(int [] arr){
        int n = arr.length;
        int c =0;
        int el = 0;
        for (int i = 0; i < n; i++) {
            if(c==0) {c=1; el = arr[i];}
            else if (arr[i] == el) {c++;}
            else c--;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == el) count++;
        }
        return (count > n/2) ? el : -1;
    }
    
    public static void main(String[] args) {
        int [] arr = {3,3,4,2,4,4,2,4,4};
        System.out.println(majority(arr));
        System.out.println(Better(arr));
        System.out.println(Opti(arr));
    }
}
