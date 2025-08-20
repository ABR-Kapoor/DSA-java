public class LngstSArrSumK_Op_negi {
    public static int LngstSArrSum(int[] arr, int k){
        int sum =arr[0];
        int maxlen = 0;
        int l =0; int r=0;
        int n = arr.length;
        while(r < n){
            while(l < r && sum > k){
                sum -= arr[l];
                l++;
            }
            if (sum ==k){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
            if (r < n) sum += arr[r];
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1,1,1,1};
        int k = 5;
        System.out.println(LngstSArrSum(arr, k));
    }
}
