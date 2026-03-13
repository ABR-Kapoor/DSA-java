// Folder context: String

class LongestPalinSubstr {

    // Helper function to expand around a center and return the length of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        // Expand outwards as long as characters match and indices are valid
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // At this point, 'left' and 'right' have moved one step too far.
        // The length of the palindrome is (right - 1) - (left + 1) + 1 = right - left - 1.
        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return ""; // this edge case tripped me up initially - empty string must return ""
        }

        int start = 0; // Starting index of the longest palindrome found
        int end = 0;   // Ending index of the longest palindrome found

        // Iterate through each character to consider it as a potential center for a palindrome
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (e.g., "aba"). Center is s[i].
            int len1 = expandAroundCenter(s, i, i);
            // Case 2: Even length palindrome (e.g., "abba"). Center is between s[i] and s[i+1].
            int len2 = expandAroundCenter(s, i, i + 1);

            // Get the maximum length found for the current center(s)
            int len = Math.max(len1, len2);

            // If the current palindrome is longer than the longest found so far
            if (len > end - start + 1) {
                // Update start and end indices of the longest palindrome.
                // For a palindrome of length 'len' centered at 'i':
                // start = i - (len - 1) / 2
                // end   = i + len / 2
                start = i - (len - 1) / 2;
                end = i + len / 2;
                // tried recursive first but iterative tracking of start/end is cleaner here for O(1) space
            }
        }
        // Return the substring corresponding to the longest palindrome found
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestPalinSubstr solver = new LongestPalinSubstr();

        // Test Cases
        System.out.println("Test Case 1: \"babad\"");
        String result1 = solver.longestPalindrome("babad");
        System.out.println("Longest Palindromic Substring: " + result1); // Expected: "bab" or "aba"

        System.out.println("\nTest Case 2: \"cbbd\"");
        String result2 = solver.longestPalindrome("cbbd");
        System.out.println("Longest Palindromic Substring: " + result2); // Expected: "bb"

        System.out.println("\nTest Case 3: \"a\"");
        String result3 = solver.longestPalindrome("a");
        System.out.println("Longest Palindromic Substring: " + result3);   // Expected: "a"

        System.out.println("\nTest Case 4: \"racecar\"");
        String result4 = solver.longestPalindrome("racecar");
        System.out.println("Longest Palindromic Substring: " + result4); // Expected: "racecar"
    }
}