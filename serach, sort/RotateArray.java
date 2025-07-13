import java.util.Scanner;

public class RotateArray {

    // Helper function to reverse a portion of the array
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the array by D elements to the left
    public static void rotateArray(int[] arr, int n, int d) {
        // If array length is 0 or no rotation is needed
        if (n == 0 || d == 0 || d == n) {
            return;
        }

        // Step 1: Reverse the first 'd' elements
        reverseArray(arr, 0, d - 1);

        // Step 2: Reverse the remaining 'n-d' elements
        reverseArray(arr, d, n - 1);

        // Step 3: Reverse the entire array
        reverseArray(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        // Input number of test cases with a prompt
        try (Scanner sc = new Scanner(System.in)) {
            // Input number of test cases with a prompt
            System.out.println("Enter the number of test cases: ");
            int t = sc.nextInt();
            
            // Process each test case
            for (int testCase = 1; testCase <= t; testCase++) {
                System.out.println("Test Case #" + testCase + ":");
                
                // Input size of the array with a prompt
                System.out.println("Enter the size of the array:");
                int n = sc.nextInt();
                
                // Input array elements with a prompt
                int[] arr = new int[n];
                System.out.println("Enter the elements of the array separated by spaces:");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                
                // Input the value of D (number of rotations) with a prompt
                System.out.println("Enter the value of D (number of positions to rotate):");
                int d = sc.nextInt();
                
                // Rotate the array by D elements
                rotateArray(arr, n, d % n);  // Modulus to handle cases where D >= N
                
                // Output the rotated array with a prompt
                System.out.println("The rotated array is:");
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();  // Print a newline for the next test case
            }
        }
    }
}
