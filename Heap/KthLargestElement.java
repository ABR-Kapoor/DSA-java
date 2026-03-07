import java.util.PriorityQueue; // Need this for the min-heap functionality

class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        // This edge case tripped me up — empty array must return -1
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // We use a min-heap to store the 'k' largest elements we've seen so far.
        // A min-heap ensures that the smallest element among the 'k' largest
        // is always at the top, ready to be removed if a larger element comes along.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            // If the heap grows larger than 'k', it means we have more than 'k'
            // candidates. The smallest of these (at the heap's top) is not
            // among the true 'k' largest, so we remove it.
            if (minHeap.size() > k) {
                minHeap.poll(); // Removes the smallest element from the heap
            }
        }

        // After processing all numbers, the min-heap will contain exactly
        // the 'k' largest elements from the array. The smallest of these
        // (which is at the top of the min-heap) is the Kth largest element overall.
        // O(k) space because of the heap, acceptable for most competitive programming tasks.
        if (minHeap.isEmpty()) { // Safety check, though pre-checked for empty nums
             return -1;
        }
        return minHeap.peek(); // Returns the top (smallest) element of the min-heap
    }

    public static void main(String[] args) {
        KthLargestElement solver = new KthLargestElement();

        // Test Case 1: Basic functionality
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Array: " + java.util.Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Kth largest element: " + solver.findKthLargest(nums1, k1)); // Expected: 5

        System.out.println("--------------------");

        // Test Case 2: Duplicate values, k = 4
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Array: " + java.util.Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Kth largest element: " + solver.findKthLargest(nums2, k2)); // Expected: 4

        System.out.println("--------------------");

        // Test Case 3: Edge case - k is larger than array size.
        // By definition, if k > N, the result is often the smallest element, or an error.
        // Our min-heap logic will naturally return the smallest element in the array here.
        int[] nums3 = {7, 6, 5, 4, 3, 2, 1};
        int k3 = 8;
        System.out.println("Array: " + java.util.Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Kth largest element: " + solver.findKthLargest(nums3, k3)); // Expected: 1

        System.out.println("--------------------");

        // Test Case 4: Edge case - empty array
        int[] nums4 = {};
        int k4 = 1;
        System.out.println("Array: " + java.util.Arrays.toString(nums4) + ", k = " + k4);
        System.out.println("Kth largest element: " + solver.findKthLargest(nums4, k4)); // Expected: -1
    }
}