package Array_Medium;

public class LongestConsequtiveSq {
    public static int b(int [] arr){
        int n = arr.length;
        int longest = 1;
        for (int i =0; i <n; i++){
            int x = arr[i];
            int count = 1;
            while(LinearSearch(arr,x+1)){
                count++; x++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
    public static boolean LinearSearch(int [] arr, int x){
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i]==x) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int [] arr = {102,4,100,1,101,3,2,1,1};
        System.out.println(b(arr));
    }
}