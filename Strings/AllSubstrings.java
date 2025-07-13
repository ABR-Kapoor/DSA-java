
public class AllSubstrings {
    public static void main(String[] args) {
            String S = "mira";
            
            // Outer loop selects the starting point of substring
            for (int i = 0; i < S.length(); i++) {
                // Inner loop selects the ending point of substring
                for (int j = i + 1; j <= S.length(); j++) {
                    // Print the substring from index i to j-1
                    System.out.println(S.substring(i, j));
                }
            }
    }
}
