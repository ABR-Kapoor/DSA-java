

public class SelectionSort {

    // this is ultra optimized code for sorting idk it's working: time complexity is O(n)
    public static class Solution {
        public int[] sortArray(int[] nums) {
            int n = nums.length;
            int[] buffer = new int[n];
            radixPass(nums, buffer, 0);
            radixPass(buffer, nums, 16);
            return nums;
        }

        private void radixPass(int[] src, int[] dst, int shift) {
            int n = src.length;
            final int BUCKETS = 1 << 16;
            final int MASK = BUCKETS - 1;
            int[] count = new int[BUCKETS];

            for (int x : src) {
                int key = (shift == 16) ? ((x ^ 0x80000000) >>> shift) & MASK : (x >>> shift) & MASK;
                count[key]++;
            }

            for (int i = 1; i < BUCKETS; i++) {
                count[i] += count[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int x = src[i];
                int key = (shift == 16) ? ((x ^ 0x80000000) >>> shift) & MASK : (x >>> shift) & MASK;
                dst[--count[key]] = x;
            }
        }
    }


    public static void swap(int[] arr) {
        for (int idx = 0; idx < arr.length - 1; idx++) {
            int min = arr[idx];
            int minIdx = idx;
            for (int i = idx + 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    minIdx = i;
                }
            }
            if (minIdx != idx) {
                arr[minIdx] = arr[idx];
                arr[idx] = min;
            }
        }
    }

    // Time Complexity: O(n^2)

    public static void selection(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            int mini = i;
            for (int j = i; j < arr.length; j++)
                if (arr[j] < arr[mini])
                    mini = j;
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
    }

    // public static void swappingBtw(int [] arr,int i, int j) {
    // int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    // }

    
    
    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };

        // selection(arr);

        Solution sol = new Solution();
        arr = sol.sortArray(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
