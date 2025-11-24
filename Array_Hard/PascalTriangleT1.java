package Array_Hard;
// function added here
public class PascalTriangleT1 {
    public static long nCr(int n, int r){
        long res =1;
        for (int i =0; i<r; i++){
            res = res * (n-i);
            res = res / (i+1);
        }
        return res;
    }
y
    publ)ic static void main(String[] args) {
        int n = 5;
        for (int i =0; i<n; i++){
            for (int j =0; j<=i; j++){
                System.out.print(nCr(i,j)+" ");
            }
            System.out.println();
        }
    }
j
