import java.util.Scanner;

public class FirstLargest {

    public static int findSecondLargest(int[] arr, int n) {
        // If array size is less than or equal to 1, return -2147483648
        if (n <= 1) {
            return -2147483648;
        }
        
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // Update firstLargest and secondLargest
            if (arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != firstLargest) {
                secondLargest = arr[i];
            }
        }

        // If secondLargest is still Integer.MIN_VALUE, return -2147483648
        if (secondLargest == Integer.MIN_VALUE) {
            return -2147483648;
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        // Input the number of test cases
        try (Scanner sc = new Scanner(System.in)) {
            // Input the number of test cases
            int t = sc.nextInt();
            
            // Loop over the test cases
            for (int i = 0; i < t; i++) {
                // Input size of the array
                int n = sc.nextInt();
                
                // Input array elements
                int[] arr = new int[n];
                for (int j = 0; j < n; j++) {
                    arr[j] = sc.nextInt();
                }
                
                // Find the second largest element in the array
                int result = findSecondLargest(arr, n);
                
                // Output the result
                System.out.println(result);
            }
        }
    }
}
