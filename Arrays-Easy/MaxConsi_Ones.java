public class MaxConsi_Ones {
public static void main(String[] args) {
    int[] arr = {1, 1, 0, 1, 1, 1, 0, 1,1,1,1,0};
    System.out.println(maxConsecutiveOnes(arr));
}

public static int maxConsecutiveOnes(int[] arr) {
    int ans = 0;
    int count = 0;
    for(int i =0; i< arr.length; i++){
        if(ans <= count && arr[i]==1){
            count++;
            ans = count;
        } else if(arr[i] == 1){
            count++;
        } else {
            count =0;
        }
    }
    return ans;
}
}
