

public class strPalindrome{

    public static boolean  strPalindromecheck(String str){

        String rev = "";

        for (int i = 0; i < str.length(); i++) {
            rev += str.charAt(i);
        }
        System.out.println(rev);
        if(str.equals(rev)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(strPalindromecheck("madam"));
    }
}