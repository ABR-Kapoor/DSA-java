package Array_Medium;

public class Sort012only {
    public static void Sort012(int [] arr){
        int z = 0, o = 0, t=0, k=0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 0) z++;
            else if (arr[i] == 1) o++;
            else t++;
        }
        while(k < z) arr[k++] = 0;
        while(k < z + o) arr[k++] = 1;
        while(k < z + o + t) arr[k++] = 2;
    }

    public static void OptiSort012(int [] arr){
        int n = arr.length;
        int low =0, mid = 0;
        int high = n-1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low ++;
                mid++;
            } else if (arr[mid] == 1){
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }
    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        OptiSort012(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
