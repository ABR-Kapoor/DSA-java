// samjh ke banao



    // freq array: O(1) space. 256 for ASCII char set, constant memory.
    // First pass, O(N): building frequency map.
    // Initializing from s.charAt(0). What if string is empty? Edge case not handled here.
    // Second pass, O(N): finding max. Returns first such char on ties.

public class HighestOccChar {

    public static char highestOccuringCharacter(String s) {
        int[] freq = new int[256];  // Frequency array for all ASCII characters
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        // Find the character with the highest frequency
        char charMax = s.charAt(0);
        int maxFreq = freq[charMax];

        for (int i = 1; i < s.length(); i++) {
            if (freq[s.charAt(i)] > maxFreq) {
                maxFreq = freq[s.charAt(i)];
                charMax = s.charAt(i);
            }
        }

        return charMax;
    }

    public static void main(String[] args) {
        String input = "welcome to omegaland";
        char result = highestOccuringCharacter(input);
        System.out.println("Highest occurring character: " + result);
    }
}