public class LngstSubArrSumK_Brute {
    public static int LongestSubArr(int [] arr, int d){
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
        int []a={1,2,3,1,1,1,1};
        System.out.println(LongestSubArr(a,6));
    }
}
