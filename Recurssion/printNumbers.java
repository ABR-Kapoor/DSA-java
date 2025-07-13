public class printNumbers {
    public static void printnumbers(int n){
        System.out.print(n + " ");
        if(n==1)
            return;
        else if(n>0)
            printnumbers(n-1);
        else if(n<0)
            printnumbers(n+1);
    }
    public static void main(String[] args) {
        printnumbers(15);
    }
}
