import java.util.Scanner;

public class RowSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input for rows and columns
        System.out.print("Enter number of rows: ");
        int i = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int j = sc.nextInt();
        
        // Initialize a 2D array and a sum array
        int[][] arr = new int[i][j];
        int[] sum = new int[i]; // Stores the sum of each row

        // Input elements for the 2D array
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                System.out.print("Enter element at (" + m + ", " + n + "): ");
                arr[m][n] = sc.nextInt();  // Corrected array indexing
            }
        }

        // Calculate the sum of each row
        for (int k = 0; k < i; k++) {
            for (int t = 0; t < j; t++) {
                sum[k] += arr[k][t];  // Corrected indexing to sum[k] and arr[k][t]
            }
        }

        // Print the sum of each row
        for (int g = 0; g < i; g++) {
            System.out.println("Sum of row " + g + " = " + sum[g]); // Output formatted correctly
        }

        sc.close();  // Close the scanner
    }
}
