public class countWords{

public static int countWord(String s){
    String[] words= s.split(" ");
    return words.length;
}

public static void main(String[] args) {

    System.out.println(countWord("teri maa ki chut lwde"));
    
}
}