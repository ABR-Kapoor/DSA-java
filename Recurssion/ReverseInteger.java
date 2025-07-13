public class ReverseInteger {

    public static int reverse(int k){
        if (k < Math.pow(-2, 31) || k > Math.pow(2, 31) - 1) 
            return 0;
        
        int n = Math.abs(k);  
        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            if (reversed > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }
            reversed = reversed * 10 + digit;
        }
        return k < 0 ? -reversed : reversed;    
    }
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(1534236469));

    }
}
