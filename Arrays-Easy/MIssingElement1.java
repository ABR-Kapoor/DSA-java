public class MIssingElement1 {
    public static int missingOne(int[] arr) {
        int n = arr.length +1;
        for(int i =0; i<n; i++){
            int flag=0;
            for(int j =0; j < n-1; j++){
                if (arr[j] == i) {
                    flag=1; break;
                }
            }
            if (flag == 0){ return i; }
        }
        return -1;
    }

    public static int BetterMissingOne(int[] arr){
        int n = arr.length + 1;
        int [] hash = new int[n];
        for (int i =0; i< n-1; i++){
            hash[arr[i]] =1;
        }
        for (int i = 0; i< n; i++){
            if( hash[i] ==0) return i;
        }
        return -1;
    }

    public static int OptiMissingOne1(int [] arr){
        int n = arr.length +1;
        int sum = (n * (n - 1)) / 2;
        int s2 = 0;
        for (int num : arr) {
            s2 += num;
        }
        return sum - s2;
    }

    public static int OptiMissingOne2(int [] arr){
        int n = arr.length +1;
        int xorE = 0 , xorC = 0;
        for (int i =0; i< n; i++){
            xorE = xorE ^ i;
        }
        for (int i : arr){
            xorC = xorC ^ i;
        }
        return xorE ^ xorC;
    }
    public static void main(String[] args) {
        int []a = {1,0,3,4,5,6};
        System.out.println(missingOne(a));
        System.out.println(BetterMissingOne(a));
        System.out.println(OptiMissingOne1(a));
        System.out.println(OptiMissingOne2(a));

    }
}
