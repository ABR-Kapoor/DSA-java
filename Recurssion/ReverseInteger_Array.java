public class ReverseInteger_Array {

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
    public static void rev(int[] i) {
        int size = i.length;
        for (int j = size - 1; j >= 0; j--) {
            System.out.print(i[j]+" ");
        } 
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void revOptimise(int i, int arr[], int n){
        if(i >= n/2) return;
        swap(arr[i], arr[n - i - 1]);
        revOptimise(i + 1, arr, n);
    }

    public static void main(String[] args) {
        // System.out.println(reverse(123));
        // System.out.println(reverse(1534236469));
        int[] arr = {1, 2, 3, 4, 5};
        revOptimise(0, arr, 5);
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
