public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 9, 15};
        int[] arr2 = {1, 4, 6, 7};
        int[] narr = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                narr[k++] = arr1[i++];
            } else {
                narr[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1, if any
        while (i < arr1.length) {
            narr[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2, if any
        while (j < arr2.length) {
            narr[k++] = arr2[j++];
        }

        // Print the merged array
        for (int value : narr) {
            System.out.print(value + " ");
        }
    }
}
