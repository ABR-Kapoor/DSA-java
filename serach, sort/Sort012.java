import java.util.Scanner;

public class Sort012 {

    // Function to sort the array containing 0, 1, and 2
    public static void sort012(int[] arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // Single scan through the array
        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap arr[low] and arr[mid], move low and mid forward
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // Just move mid forward
                mid++;
            } else { // arr[mid] == 2
                // Swap arr[mid] and arr[high], move high backward
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        // Input number of test cases
        try (Scanner sc = new Scanner(System.in)) {
            // Input number of test cases
            int t = sc.nextInt();
            
            // Process each test case
            for (int i = 0; i < t; i++) {
                // Input the size of the array
                int n = sc.nextInt();
                
                // Input the array elements
                int[] arr = new int[n];
                for (int j = 0; j < n; j++) {
                    arr[j] = sc.nextInt();
                }
                
                // Sort the array containing 0, 1, and 2
                sort012(arr, n);
                
                // Output the sorted array
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();  // Newline for next test case output
            }
        }
    }
}
