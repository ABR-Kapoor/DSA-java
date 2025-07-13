public class RemChar {

    public static void remchar(String s, char c) {
        String result = "";  // Create an empty string to store the result

        // Iterate over the original string
        for (int i = 0; i < s.length(); i++) {
            // If the character is not the one to be removed, add it to the result
            if (s.charAt(i) != c) {
                result += s.charAt(i);  // Concatenation creates a new string each time
            }
        }

        // Print the final result
        System.out.println(result);
    }

    public static void main(String[] args) {
        remchar("welcome to omegaland", 'o');
    }
}
