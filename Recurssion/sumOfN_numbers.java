public class sumOfN_numbers {
    public static int sumOfnumbers(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfnumbers(n - 1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumOfnumbers(n));
    }
}
