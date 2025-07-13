import java.util.Scanner;

public class sumRow{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter row= ");
        int i = sc.nextInt();

        System.out.print("enter col= ");
        int j = sc.nextInt();
        
        int sum [] = new int [i];

        int arr [][] = new int[i][j];

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                System.out.println("enter: \n:( "+m+", "+n+" ) element: ");
                arr[m][n] = sc.nextInt();                
            }
        }

        for (int k = 0; k < i; k++) {
            for (int t = 0; t < j; t++) {
                sum[k] += arr[k][t];
            }
        }
        for (int g = 0; g < i; g++) {
            for (int c = 0; c < j; c++) {
                System.out.print("sum of: \n"+ g +"th =" + sum[g]);
            }
        }
        
    }

}