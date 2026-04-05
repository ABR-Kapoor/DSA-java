public class fibonachi_iValue {
    // 'fOptimised' is a misnomer; ternary operator offers no performance gain. Still O(2^n) due to redundant calls.
    // Pure recursive Fibonacci is elegant for small 'n', but practically useless for anything above n=40-50 without memoization.
    // The actual 'optimization' lies in dynamic programming (iterative or memoized) for O(n) time complexity.
    // Real efficiency demands more than just concise syntax.

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