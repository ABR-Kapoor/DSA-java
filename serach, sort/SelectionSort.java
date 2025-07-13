public class SelectionSort {

    public static void swap(int []arr){
        for (int idx = 0; idx < arr.length -1; idx++) {
            int min = arr[idx];
            int minIdx = idx;
            for (int i = idx +1; i < arr.length; i++){
                if (arr[i] < min) {
                    min = arr[i];
                    minIdx = i;
                }
            }
            if (minIdx != idx) {
                arr[minIdx] = arr[idx];
                arr[idx] = min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        
        swap(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        

    }
}
