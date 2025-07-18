public class nTo1_wo_n1 {
    public static void printN_1(int i, int n){
        if (i<1) return;
        printN_1(i-1,n);
        System.out.print(i + " ");
        return;
    }
    public static void main(String[] args) {
        int n = 5;
        printN_1(n,n);
    }
}
