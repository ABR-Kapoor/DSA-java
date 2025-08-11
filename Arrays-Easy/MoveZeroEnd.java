public class MoveZeroEnd {
    public static int [] moveZeroes(int[] arr) {
        int j = -1;
        for(int i =0; i < arr.length; i++){
            if(arr[i] == 0){
                j=i;
                break;
            }
        }
        if (j==-1) return arr;
        for (int i = j+1; i<arr.length; i++){
            if(arr[i] != 0){
                swap(arr,i,j);
                j++;
            }
        }
        return arr;
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}