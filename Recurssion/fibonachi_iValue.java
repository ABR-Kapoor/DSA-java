public class fibonachi_iValue {
    public static int fibonacci(int n){
        if (n <= 1){
            return n;
        }
        return (fibonacci(n-1) + fibonacci(n-2));
    }

    public static int fOptimised(int n){
        return n <= 1 ? n : fOptimised(n - 1) + fOptimised(n - 2);
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Fibonacci value at index " + n + " is: " + fibonacci(n));
        System.out.println("Fibonacci value at index " + n + " is: " + fOptimised(n));
    }
}
