public class RemConsecutiveDup {

    // Method to remove consecutive duplicate characters
    public static String remConscutDipli(String s) {
        if (s == null || s.length() <= 1) {
            return s;  // If string is null or too short, return as is
        }

        // Use StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();
        char[] chArr = s.toCharArray();  // Convert string to character array

        result.append(chArr[0]);  // Add the first character

        // Loop through the characters starting from index 1
        for (int i = 1; i < chArr.length; i++) {
            // Add character if it's not the same as the previous one
            if (chArr[i] != chArr[i - 1]) {
                result.append(chArr[i]);
            }
        }

        return result.toString();  // Convert StringBuilder to String
    }

    public static void main(String[] args) {
        String input = "xyyzx";
        String output = remConscutDipli(input);
        System.out.println("Original: " + input);
        System.out.println("Without consecutive duplicates: " + output);
    }
}
