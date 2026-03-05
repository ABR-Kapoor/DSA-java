class FindPeakElem {

    public int findPeakElement(int[] nums) {
        // this edge case tripped me up initially — an empty array should likely return -1
        // but problem constraints often guarantee at least one element. For LC 162, it's 1 <= nums.length
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        // Binary search is perfect here, O(log N) is hard to beat for large arrays.
        while (low < high) {
            int mid = low + (high - low) / 2;

            // this 'mid + 1' comparison is the core logic that steers us towards a peak.
            // If mid is on an ascending slope, a peak must be to its right.
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } 
            // If mid is on a descending slope or is a peak, a peak must be at or to its left.
            else {
                high = mid;
            }
        }
        // When low == high, we've converged on a peak.
        // remember to handle the base case where low and high meet – that's our peak.
        return low; 
    }

    public static void main(String[] args) {
        FindPeakElem solver = new FindPeakElem();

        // Test Case 1: Simple peak in the middle
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: [1, 2, 3, 1], Peak Index: " + solver.findPeakElement(nums1)); // Expected: 2

        // Test Case 2: Peak at an edge
        int[] nums2 = {3, 4, 3, 2, 1};
        System.out.println("Input: [3, 4, 3, 2, 1], Peak Index: " + solver.findPeakElement(nums2)); // Expected: 1

        // Test Case 3: Multiple peaks, return any
        int[] nums3 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Input: [1, 2, 1, 3, 5, 6, 4], Peak Index: " + solver.findPeakElement(nums3)); // Expected: 5 (could also be 1)

        // Test Case 4: Single element array
        int[] nums4 = {7};
        System.out.println("Input: [7], Peak Index: " + solver.findPeakElement(nums4)); // Expected: 0

        // Test Case 5: Two elements, increasing
        int[] nums5 = {1, 2};
        System.out.println("Input: [1, 2], Peak Index: " + solver.findPeakElement(nums5)); // Expected: 1
    }
}