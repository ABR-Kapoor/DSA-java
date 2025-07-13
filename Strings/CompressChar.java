public class CompressChar {

    public static void CompressWithNumber(String s) {
        int[] frq = new int[256];  // Frequency array for all ASCII characters

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            frq[s.charAt(i)]++;
        }

        // Track printed characters to avoid duplicate prints
        boolean[] printed = new boolean[256];

        // Print characters along with their frequency
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!printed[ch]) {  // Only print if not printed before
                System.out.print(ch);
                if (frq[ch] > 1) {
                    System.out.print(frq[ch]);
                }
                printed[ch] = true;  // Mark character as printed
            }
        }
        System.out.println();  // Newline after output
    }

    public static void main(String[] args) {
        CompressWithNumber("aabcccddaa");  // Output: a2bc3d2e
    }
}
