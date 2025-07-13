import java.util.Scanner;

public class CheckArrayRotation {

    public static int findRotationIndex(int[] arr, int n) {
        // If the array has only one or zero elements, it can't be rotated.
        if (n <= 1) {
            return 0;
        }

        // Traverse the array to find the rotation point
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }

        // If no rotation point is found, the array is not rotated
        return 0;
    }

    public static void main(String[] args) {
        // Input number of test cases
        try (Scanner sc = new Scanner(System.in)) {
            // Input number of test cases
            int t = sc.nextInt();
            
            // Process each test case
            for (int testCase = 0; testCase < t; testCase++) {
                // Input size of the array
                int n = sc.nextInt();
                
                // Input array elements
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                
                // Find and print the rotation index for this array
                System.out.println(findRotationIndex(arr, n));
            }
        }
    }
}
