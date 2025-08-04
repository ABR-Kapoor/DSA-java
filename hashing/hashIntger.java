package hashing;

import java.util.Scanner;

public class hashIntger {
    static int[] hash = new int[(int) 1e7];  //globally 1e7, for bool- 1e8
    public static void main(String[] args) {
        int n;
        System.out.print("enter size of an array: ");
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // precompute
            // int[] hash = new int[(int) 1e6];  // size 1e6, for bool- 1e7
            for (int i = 0; i < arr.length; i++) {
                hash[arr[i]] += 1;
            }

            System.out.print("enter number of queries: ");
            int q = sc.nextInt();

            for (int i = 0; i < q; i++) {
                System.out.print("enter number to get count of: ");
                int num = sc.nextInt();
                // fetch
                System.out.println("number of element(s) are: " + hash[num]);
            }
        }

    }
}
