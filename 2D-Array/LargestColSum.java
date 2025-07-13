public class LargestColSum {
    public static int largeColSum(int [][] arr){
        int max = Integer.MIN_VALUE;
        int row = arr.length;
        int col = arr[0].length;
        int sum;
        for(int j = 0; j < col; j++){
            sum = 0;
            for(int i = 0; i<row; i++){
                sum += arr[i][j];
            }
            if(sum >= max){
                max = sum;
            }
        }


        return max;
    }

    public static void printArr(int[] [] arr){
        int row = arr.length;
        int col = arr[0].length;

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,4}, {99,4,9}};
        printArr(arr);
        System.out.println(largeColSum(arr));
    }
}
