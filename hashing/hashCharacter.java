package hashing;

import java.util.Scanner;

public class hashCharacter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("enter the string: ");
            String s = sc.nextLine();

            // precompute
            int [] hash = new int[256];
            for (int i = 0; i < s.length(); i++) {
                hash[s.charAt(i)]++;
            }

            System.out.println("enter number of queries: ");
            int q = sc.nextInt();

            for (int i = 0; i < q; i++) {
                System.out.print("enter the character: ");
                char c = sc.next().charAt(0);
                if (c < 0 || c >= 256) {
                    System.out.println("Character out of range");
                } else {
                    System.out.println(hash[c] + " times.");
                }
            }
        }

    }
}
