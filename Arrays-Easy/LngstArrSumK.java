public class LngstArrSumK {
    public static int LongestArr(int [] arr, int d){
        int n = arr.length;
        int len = 0;
        for(int i=0; i < n; i++){
            int sum =0;
            for(int j=0; j<n; j++){
                for(int k =i; k<=j; k++){
                    sum += arr[k];
                    if(sum == d) { 
                        len = Math.max(len, j-i+1);
                    }
                }
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int []a={3,2,5,1,3,2};
        System.out.println(LongestArr(a,6));
    }
}
