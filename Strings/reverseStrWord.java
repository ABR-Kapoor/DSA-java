public class reverseStrWord {

    public static void revStrWord(String s){
        String str[] = s.split(" ");
        int nWords = str.length;
        for(int i = 0; i < nWords; i++){
        System.out.print(str[i]+" ");
        }
        System.out.println();
        for(int i=nWords-1; i >= 0; i--){
            System.out.print(str[i]+" ");
        }
    }

    public static void main(String[] args) {
        revStrWord("I love Coding ninja");
    }
}
