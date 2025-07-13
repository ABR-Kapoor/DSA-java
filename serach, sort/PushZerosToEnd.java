import java.util.Scanner;

public class PushZerosToEnd {

    // Method to push zeros to end in a single scan
    public static void pushZerosToEnd(int[] arr, int n) {
        int j = 0; // This will track the position for the next non-zero element
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i]; // Move the non-zero element to the position j
                j++; // Increment j to point to the next position
            }
        }
        
        // Fill the rest of the array with zeros
        for (int i = j; i < n; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("enter input: ");
            
            // Input number of test cases
            int t = sc.nextInt();
            
            while (t-- > 0) {
                // Input size of the array
                int n = sc.nextInt();
                
                // Input array elements
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                
                // Call the method to push zeros to the end
                pushZerosToEnd(arr, n);
                
                // Output the modified array
                for (int i = 0; i < n; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
