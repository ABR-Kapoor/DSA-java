public class SLargest {
    public static int findSLargest(int[] arr) {
            int largest = Integer.MIN_VALUE;
            int secondLargest = Integer.MIN_VALUE;
            for (int i=0; i< arr.length; i++){
                if (arr[i] > largest){
                    secondLargest = largest;
                    largest = arr[i];
                } else if (arr[i] > secondLargest && arr[i] != largest){
                    secondLargest = arr[i];
                }
            }
            return secondLargest;
    }

    public static void main(String[] var0) {
        int[] var1 = new int[] { 2, 4, 2, 62, 4, 8 };
        System.out.println(findSLargest(var1));
    }
}
