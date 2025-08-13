import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnionSortedArr {
    public static int[] union(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            set.add(i);
        }
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public static ArrayList<Integer> unionArrList(int[] a, int[] b) {
        Set<Integer> union = new HashSet<>();
        for (int i : a) {
            union.add(i);
        }
        for (int i : b) {
            union.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>(union);
        Collections.sort(result);
        return result;
    }

    public static ArrayList<Integer> OptiUnion(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int i = 0, j = 0;
        ArrayList<Integer> unionArr = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != a[i]) {
                    unionArr.add(a[i]);
                }
                i++;
            } else {
                if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != b[j]) {
                    unionArr.add(b[j]);
                }
                j++;
            }
        }
        while (i < n1) {
            if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != a[i]) {
                unionArr.add(a[i]);
            }
            i++;
        }
        while (j < n2) {
            if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != b[j]) {
                unionArr.add(b[j]);
            }
            j++;
        }
        Collections.sort(unionArr);
        return unionArr;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 77, 5 };
        int b[] = { 3, 4, 5, 6, 7 };
        ArrayList<Integer> result =  OptiUnion(a, b);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}
