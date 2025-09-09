package Array_Medium;

import java.util.ArrayList;

public class RearrArrBySignNotEq {
    public static int [] f(int [] arr){
        int n = arr.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i <n; i++) {
            if(arr[i] > 0) pos.add(arr[i]);
            else neg.add(arr[i]);
        }
        if(pos.size() > neg.size()){
            for(int i = 0; i < neg.size(); i++) {
                arr[i*2] = pos.get(i);
                arr[i*2+1] = neg.get(i);
            }
            int index = neg.size()*2;
            for(int i = neg.size(); i< pos.size(); i++){
                arr[index++] = pos.get(i);
            }
        } else {
            for(int i = 0; i < pos.size(); i++) {
                arr[i*2] = neg.get(i);
                arr[i*2+1] = neg.get(i);
            }
            int index = pos.size()*2;
            for(int i = pos.size(); i< neg.size(); i++){
                arr[index++] = neg .get(i);
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int [] arr = {3,1,-2,-5,2,-4,-6};
        int [] res = f(arr);
        for (int i : res) System.out.print(i + " ");
    }
}
