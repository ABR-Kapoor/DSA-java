import java.util.ArrayList;
public class MergeSortArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(6);
        arr1.add(1);
        arr1.add(15);
        mergeSort(arr1, 0, arr1.size() - 1);
        for (int value : arr1) {
            System.out.print(value + " ");
        }
    }

    public static void mergeSort(ArrayList<Integer> arr1, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr1, low, mid);
        mergeSort(arr1, mid + 1, high);
        merge(arr1, low, mid, high);
    }

    public static void merge(ArrayList<Integer> arr1, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr1.get(left) <= arr1.get(right)) {
                temp.add(arr1.get(left++));
            } else {
                temp.add(arr1.get(right++));
            }
        }
        while (left <= mid) {
            temp.add(arr1.get(left++));
        }
        while (right <= high) {
            temp.add(arr1.get(right++));
        }
        for (int i = 0; i < temp.size(); i++) {
            arr1.set(low + i, temp.get(i));
        }
    }
}