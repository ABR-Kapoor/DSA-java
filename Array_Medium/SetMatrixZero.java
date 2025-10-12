package Array_Medium;

public class SetMatrixZero {
    public void B(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i< m; i++){
            for (int j = 0; j < n; j++){
                if(arr[i][j] ==0){
                    markRow(arr,i);
                    markCol(arr,j);
                }
            }
        }
        for(int i = 0; i <m; i++){
            for(int j =0; j <n; j++){
                if(arr[i][j] == -1){
                    arr[i][j] =0;
                }
            }
        }
    }
    void markCol(int[][] arr, int j){
        int m = arr.length;
        for(int i = 0; i < m; i++){
            if(arr[i][j] != 0) arr[i][j] = -1;
        }
    }

    public void Better(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[] row = new int[n];
        int [] col = new int[m];
        for (int i =0; i < n; i++){
            for (int j = 0; j <m; j++){
                if (arr[i][j] ==0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i <n; i++){
            for (int j = 0; j <m; j++){
                if (row[i] == 1 || col[j] == 1){
                    arr[i][j] = 0;
                }
            }
        }
    }

    void markRow(int[][] arr, int i){
        int n = arr[0].length;
        for(int j = 0; j < n; j++){
            if(arr[i][j] != 0) arr[i][j] = -1;
        }
    }

    public static void main(String[] args) {
        SetMatrixZero obj = new SetMatrixZero();
        int[][] arr = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        // obj.B(arr);
        obj.Better(arr);

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
