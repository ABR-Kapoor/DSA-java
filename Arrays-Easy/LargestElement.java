class LargestElement {
    public static int findLargest(int[] arr) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 2, 62, 4, 8 };
        System.out.println(findLargest(arr));
    }
}
