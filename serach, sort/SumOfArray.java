public class SumOfArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = {5,4,3,2,1};
        int sum[] = new int[5];

        for (int i = 0; i < 5; i++) {
            sum[i] = array[i]+array2[i];
        }
        System.out.print("sum is: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(sum[i]+" ");
        }
    }
}
