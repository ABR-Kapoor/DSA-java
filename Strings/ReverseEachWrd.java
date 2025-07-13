public class ReverseEachWrd{

    public static void RrseEachWord(String s){
        String[] words = s.split(" ");
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                System.out.print(word.charAt(word.length() - j - 1));
            }
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        String s = "Hello mera naam Apple hai";
        RrseEachWord(s);
    }
}