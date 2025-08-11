public class RotateArraybyD {

    public static void rotate(int[] arr){
        int n= arr.length;
        int temp = arr[n-1];
        for(int i = n-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }


    public static void rotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        int temp[] = new int[d];
        for(int i=0; i <= temp.length-1; i++){
            temp[i] = arr[i];
        }
        for(int i=d; i<n; i++){
            arr[i-d] = arr[i];
        }
        // int j = 0;
        for(int i=n-d; i<n; i++){
            arr[i] = temp[i-(n-d)];
        }
    }

    public static void Optirotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle cases where k > n

        // Reverse the whole array
        reverse(arr, 0, n - 1);
        // Reverse first k elements
        reverse(arr, 0, k - 1);
        // Reverse remaining elements
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
	    Optirotate(arr,8);
	    for(int i : arr){
	        System.out.print(i+ " ");
	    }
		System.out.println("\nHello World");
    }
}