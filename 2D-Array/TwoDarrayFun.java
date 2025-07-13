import java.util.Scanner;

public class TwoDarrayFun {

    public static int [][] takeInput(int [][] input){
        Scanner sc = new Scanner(System.in);
        int row = input.length;
        int col = input[0].length;
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < col; n++) {
                System.out.print("Enter element at (" + m + ", " + n + "): ");
                input[m][n] = sc.nextInt();  // Corrected array indexing
            }
        }
        
        return input;
    }

    public static void printArr(int[] [] arr){
        int row = arr.length;
        int col = arr[0].length;

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("enter row: ");
        int row = Scanner.nextInt();

        System.out.print("enter col: ");
        int col = Scanner.nextInt();
        int arry [] [] = new int[row][col];
        takeInput(arry);
        printArr(arry);
    }
}
