import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public int[] findTwoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            // this edge case tripped me up — array must have at least two elements for a sum
            return new int[] {-1, -1};
        }

        Map<Integer, Integer> numMap = new HashMap<>(); // Stores number -> its index
        // The HashMap uses O(n) space, but it's a fair tradeoff for the O(n) time complexity. Totally worth it.

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            if (numMap.containsKey(complement)) {
                // Found the pair!
                return new int[] {numMap.get(complement), i};
            }
            numMap.put(currentNum, i);
        }

        // If no solution is found after iterating through all elements.
        // Honestly, the problem statement often guarantees a solution, but handling no-solution is crucial in real-world code.
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        System.out.println("--- Two Sum Solver ---");

        // Test Case 1: Standard case
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solver.findTwoSum(nums1, target1);
        System.out.println("\nTest 1:");
        System.out.println("Array = {2, 7, 11, 15}, Target = 9");
        System.out.println("Indices: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [0, 1]

        // Test Case 2: Numbers with duplicates, different order
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solver.findTwoSum(nums2, target2);
        System.out.println("\nTest 2:");
        System.out.println("Array = {3, 2, 4}, Target = 6");
        System.out.println("Indices: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [1, 2]

        // Test Case 3: No solution
        int[] nums3 = {1, 5, 9};
        int target3 = 100;
        int[] result3 = solver.findTwoSum(nums3, target3);
        System.out.println("\nTest 3:");
        System.out.println("Array = {1, 5, 9}, Target = 100");
        System.out.println("Indices: [" + result3[0] + ", " + result3[1] + "]"); // Expected: [-1, -1]

        // Test Case 4: Empty array
        int[] nums4 = {};
        int target4 = 5;
        int[] result4 = solver.findTwoSum(nums4, target4);
        System.out.println("\nTest 4:");
        System.out.println("Empty Array = {}, Target = 5");
        System.out.println("Indices: [" + result4[0] + ", " + result4[1] + "]"); // Expected: [-1, -1]
    }
}