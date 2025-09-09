package Array_Medium;

public class RearrngeArrBySignEqual {
    public int [] br(int [] arr){
        int n = arr.length;
        int [] pos = new int[n/2];
        int [] neg = new int[n/2];
        int p = 0, q = 0;
        for (int i =0; i<n; i++){
            if(arr[i] > 0)  pos[p++] = arr[i];
            else neg[q++] = arr[i];
        } 
        for  (int i = 0; i < n/2; i++){
            arr[2*i] = pos[i];
            arr[2*i+1] = neg[i];
        }
        return arr;
    }
    public static void main(String[] args) {
        RearrngeArrBySignEqual obj = new RearrngeArrBySignEqual();
        int [] arr = {3,1,-2,-5,2,-4};
        int [] res = obj.br(arr);
        for (int i : res) System.out.print(i + " ");
    }
}
