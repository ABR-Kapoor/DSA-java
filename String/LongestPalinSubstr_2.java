class LongestPalinSubstr {

    // To avoid returning multiple values (start index and length) from the helper,
    // I'm using instance variables to keep track of the longest palindrome found so far.
    // This feels less verbose for a quick problem solve.
    private int currentLongestStart = 0;
    private int currentLongestLength = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return ""; // An empty string or null doesn't have a palindrome. Easy edge case.
        }

        for (int i = 0; i < s.length(); i++) {
            // For odd-length palindromes, like "aba", the center is 'b' (index i)
            expandAroundCenter(s, i, i);
            // For even-length palindromes, like "abba", the center is between 'b' and 'b' (indices i and i+1)
            expandAroundCenter(s, i, i + 1);
        }

        // Once we've checked all possible centers, currentLongestStart and currentLongestLength
        // will hold the details of the longest one.
        return s.substring(currentLongestStart, currentLongestStart + currentLongestLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        // Keep expanding outwards as long as we're within bounds AND characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // The 'while' loop exits one step too far (left is too small, right is too big).
        // So, the actual start index is (left + 1) and the end index is (right - 1).
        // Length = (end index - start index + 1)
        // Length = (right - 1) - (left + 1) + 1
        // Length = right - left - 1. This off-by-one calculation always gets me.
        int currentPalindromeLength = right - left - 1;

        // If this palindrome is longer than our current record, update it.
        if (currentPalindromeLength > currentLongestLength) {
            currentLongestLength = currentPalindromeLength;
            currentLongestStart = left + 1; // Remember, actual start is one step past the final 'left'
        }
    }

    public static void main(String[] args) {
        LongestPalinSubstr solver = new LongestPalinSubstr();

        // Test cases - trying a few to confirm logic
        String test1 = "babad";
        System.out.println("Input: \"" + test1 + "\" -> Longest Palindrome: \"" + solver.longestPalindrome(test1) + "\""); // Should be "bab" or "aba"
        solver = new LongestPalinSubstr(); // Re-initializing the solver to reset instance vars for the next test.
                                           // A bit clunky for unit testing, but works for a quick main().

        String test2 = "cbbd";
        System.out.println("Input: \"" + test2 + "\" -> Longest Palindrome: \"" + solver.longestPalindrome(test2) + "\""); // Should be "bb"
        solver = new LongestPalinSubstr();

        String test3 = "a";
        System.out.println("Input: \"" + test3 + "\" -> Longest Palindrome: \"" + solver.longestPalindrome(test3) + "\""); // Should be "a"
        solver = new LongestPalinSubstr();

        String test4 = "racecar";
        System.out.println("Input: \"" + test4 + "\" -> Longest Palindrome: \"" + solver.longestPalindrome(test4) + "\""); // Full string "racecar"
        solver = new LongestPalinSubstr();

        String test5 = ""; // Empty string edge case
        System.out.println("Input: \"" + test5 + "\" -> Longest Palindrome: \"" + solver.longestPalindrome(test5) + "\""); // Should be ""
    }
}