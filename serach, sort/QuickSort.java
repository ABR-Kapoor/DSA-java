public class QuickSort {
    public static void QS(int arr[], int low, int high){
        if (low < high) {
            int p = p(arr,low, high);
            QS(arr, low, p-1);
            QS(arr, p+1, high);
        }
    }
    public static int p(int[]arr, int low, int high){
        int i= low;
        int j=high;
        int pivot = arr[low];
        while(i<j){
            while (arr[i] <= pivot && i <= high - 1) i++;
            while (arr[j] > pivot && j >= low + 1) j--;
            if (i<j) swap(arr,i,j);
        }
        swap(arr, low, j);
        return j;
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 2, 6, 4, 8};
        // mergeSort(arr, 0, arr.length - 1);
        QS(arr, 0, arr.length - 1);


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
