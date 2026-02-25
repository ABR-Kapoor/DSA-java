// DP folder context (no package specified for student-like submission)

class LongestCommonSubseq {

    // Memoization table to store results of subproblems.
    // Initialized with -1 to indicate an uncomputed state.
    private static int[][] memo;

    /**
     * Calculates the length of the Longest Common Subsequence (LCS) between two strings
     * using a recursive approach with memoization (top-down Dynamic Programming).
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return The length of the LCS.
     */
    public static int findLCSLength(String s1, String s2) {
        // Recursive approach with memoization makes sense for overlapping subproblems.
        // I tried iterative (bottom-up DP) first, but recursive with memoization felt more intuitive to implement for me at first.

        int m = s1.length();
        int n = s2.length();

        memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1; // Initialize with -1 to mark uncomputed states.
            }
        }
        // This initial state handling sometimes tripped me up — the problem spec for another problem once said
        // "empty array must return -1", which is different from a calculated LCS length of 0 here.
        // It's a subtle distinction between "not computed" (our -1) and "computed to zero".

        return solveLCS(s1, s2, m, n);
    }

    /**
     * Helper recursive function to compute LCS length with memoization.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @param m  Current length of s1 (or index boundary).
     * @param n  Current length of s2 (or index boundary).
     * @return The length of the LCS for s1[0...m-1] and s2[0...n-1].
     */
    private static int solveLCS(String s1, String s2, int m, int n) {
        // Base case: If either string becomes empty, LCS length is 0.
        if (m == 0 || n == 0) {
            return 0;
        }

        // Check memoization table: If this subproblem has already been solved, return the stored result.
        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        // If the last characters of the current substrings match:
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            // Include this character in LCS and recurse for remaining strings.
            memo[m][n] = 1 + solveLCS(s1, s2, m - 1, n - 1);
        } else {
            // If characters don't match, explore two possibilities:
            // 1. Skip the last character of s1.
            // 2. Skip the last character of s2.
            // Take the maximum length from these two options.
            memo[m][n] = Math.max(solveLCS(s1, s2, m - 1, n), solveLCS(s1, s2, m, n - 1));
        }

        // O(m*n) space for the DP table and O(m*n) time complexity. Stack space can add up for very deep recursions.
        return memo[m][n];
    }

    public static void main(String[] args) {
        System.out.println("Longest Common Subsequence (LCS) with Memoization:\n");

        // Test Case 1: Standard example
        String test1_s1 = "ABCBDAB";
        String test1_s2 = "BDCABA";
        System.out.println("LCS of \"" + test1_s1 + "\" and \"" + test1_s2 + "\" is: " + findLCSLength(test1_s1, test1_s2)); // Expected: 4 (e.g., "BCBA")

        // Test Case 2: Common subsequence with scattered characters
        String test2_s1 = "AGGTAB";
        String test2_s2 = "GXTXAYB";
        System.out.println("LCS of \"" + test2_s1 + "\" and \"" + test2_s2 + "\" is: " + findLCSLength(test2_s1, test2_s2)); // Expected: 4 (e.g., "GTAB")

        // Test Case 3: One empty string
        String test3_s1 = "ABCD";
        String test3_s2 = "";
        System.out.println("LCS of \"" + test3_s1 + "\" and \"" + test3_s2 + "\" is: " + findLCSLength(test3_s1, test3_s2)); // Expected: 0

        // Test Case 4: No common characters at all
        String test4_s1 = "XYZ";
        String test4_s2 = "PQR";
        System.out.println("LCS of \"" + test4_s1 + "\" and \"" + test4_s2 + "\" is: " + findLCSLength(test4_s1, test4_s2)); // Expected: 0

        // Test Case 5: Identical strings
        String test5_s1 = "HELLO";
        String test5_s2 = "HELLO";
        System.out.println("LCS of \"" + test5_s1 + "\" and \"" + test5_s2 + "\" is: " + findLCSLength(test5_s1, test5_s2)); // Expected: 5

        // Test Case 6: Longer, more complex strings
        String test6_s1 = "CHARACTER";
        String test6_s2 = "ARTIST";
        System.out.println("LCS of \"" + test6_s1 + "\" and \"" + test6_s2 + "\" is: " + findLCSLength(test6_s1, test6_s2)); // Expected: 3 (e.g., "ART")
    }
}