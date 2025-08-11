import java.util.stream.IntStream;

public class IsArraySort{
    public static boolean check(int [] arr){
        return IntStream.range(0, arr.length).filter(i -> arr[i] > arr[(i+1) % arr.length]).count() <=1;
    }
    public static boolean check2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2};
        System.out.println(check(arr)); // true
        int [] arr2 = {3,4,5,6,1,2};
        System.out.println(check2(arr2)); // false   
    }
}