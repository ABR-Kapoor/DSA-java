// Folder context: BinarySearch
class FindPeakElem {

    public int findPeakElement(int[] nums) {
        // this edge case tripped me up — an empty array should probably return -1
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // simple while(left < right) loop, standard binary search template. Kaam aayega.
        while (left < right) {
            int mid = left + (right - left) / 2; // Avoids overflow for large left/right values

            // Key insight: if nums[mid] is on an upward slope (nums[mid] < nums[mid+1]),
            // a peak is guaranteed to exist to the right of mid. So, we explore right.
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // Otherwise, nums[mid] is either a peak or on a downward slope.
                // A peak could be mid itself or to its left. So, we explore left,
                // keeping mid in consideration.
                right = mid;
            }
        }

        // When the loop terminates, 'left' (which equals 'right') will be
        // pointing to an index that satisfies the peak element condition.
        // The problem guarantees at least one peak exists in non-empty array
        // (with implicit nums[-1] = nums[n] = -infinity).
        return left;
    }

    public static void main(String[] args) {
        FindPeakElem solver = new FindPeakElem();

        // Test Case 1: Standard case with multiple peaks, returns one
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak element index in " + java.util.Arrays.toString(nums1) + ": " + solver.findPeakElement(nums1)); // Expected: 2 (value 3)

        // Test Case 2: Another standard case with multiple peaks
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak element index in " + java.util.Arrays.toString(nums2) + ": " + solver.findPeakElement(nums2)); // Expected: 5 (value 6)

        // Test Case 3: Array with one element
        int[] nums3 = {7};
        System.out.println("Peak element index in " + java.util.Arrays.toString(nums3) + ": " + solver.findPeakElement(nums3)); // Expected: 0 (value 7)

        // Test Case 4: Array with two elements, increasing
        int[] nums4 = {1, 2};
        System.out.println("Peak element index in " + java.util.Arrays.toString(nums4) + ": " + solver.findPeakElement(nums4)); // Expected: 1 (value 2)

        // Test Case 5: Array with two elements, decreasing
        int[] nums5 = {2, 1};
        System.out.println("Peak element index in " + java.util.Arrays.toString(nums5) + ": " + solver.findPeakElement(nums5)); // Expected: 0 (value 2)

        // Test Case 6: Strictly increasing array (last element is peak)
        int[] nums6 = {1, 2, 3, 4, 5};
        System.out.println("Peak element index in " + java.util.Arrays.toString(nums6) + ": " + solver.findPeakElement(nums6)); // Expected: 4 (value 5)

        // Test Case 7: Strictly decreasing array (first element is peak)
        int[] nums7 = {5, 4, 3, 2, 1};
        System.out.println("Peak element index in " + java.util.Arrays.toString(nums7) + ": " + solver.findPeakElement(nums7)); // Expected: 0 (value 5)

        // Test Case 8: Empty array - should return -1 as per our handling
        int[] nums8 = {};
        System.out.println("Peak element index in " + java.util.Arrays.toString(nums8) + ": " + solver.findPeakElement(nums8)); // Expected: -1

        // Test Case 9: Null array - should return -1
        int[] nums9 = null;
        System.out.println("Peak element index in " + nums9 + ": " + solver.findPeakElement(nums9)); // Expected: -1
    }
}