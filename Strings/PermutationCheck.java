import java.util.Arrays;

public class PermutationCheck {

    public static boolean chckPermu(String one, String two) {
        // If the lengths are different, they can't be permutations
        if (one.length() != two.length()) {
            return false;
        }

        // Convert both strings to character arrays
        char[] arr1 = one.toCharArray();
        char[] arr2 = two.toCharArray();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare the sorted arrays
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "def";

        if (chckPermu(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are permutations.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not permutations.");
        }
    }
}
