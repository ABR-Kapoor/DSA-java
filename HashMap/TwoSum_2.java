import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // We need a map to quickly check if a complement exists.
        // It stores number -> index.
        Map<Integer, Integer> numIndexMap = new HashMap<>(); // O(n) space for the map, totally worth it for O(n) time

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            if (numIndexMap.containsKey(complement)) {
                // Found the pair! Return indices.
                return new int[] { numIndexMap.get(complement), i };
            }

            // Not found yet, so add current number to the map for future checks.
            numIndexMap.put(currentNum, i);
        }

        // If no pair is found after checking all numbers.
        // This part usually means no solution exists for the given input.
        return new int[] {}; // this edge case for no solution tripped me up once, good to return an empty array
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        System.out.println("--- Running TwoSum Test Cases ---");

        // Test Case 1: Simple scenario
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solver.twoSum(nums1, target1);
        System.out.println("\nTest Case 1: nums = [2, 7, 11, 15], target = 9");
        if (result1.length == 2) {
            System.out.println("Result indices: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [0, 1]
        } else {
            System.out.println("No pair found.");
        }

        // Test Case 2: Duplicate numbers, but different indices
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solver.twoSum(nums2, target2);
        System.out.println("\nTest Case 2: nums = [3, 2, 4], target = 6");
        if (result2.length == 2) {
            System.out.println("Result indices: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [1, 2]
        } else {
            System.out.println("No pair found.");
        }

        // Test Case 3: No solution possible
        int[] nums3 = {1, 2, 3};
        int target3 = 7;
        int[] result3 = solver.twoSum(nums3, target3);
        System.out.println("\nTest Case 3: nums = [1, 2, 3], target = 7");
        if (result3.length == 2) {
            System.out.println("Result indices: [" + result3[0] + ", " + result3[1] + "]");
        } else {
            System.out.println("No pair found."); // Expected: No pair found.
        }

        // Test Case 4: Array with zeros
        int[] nums4 = {0, 4, 3, 0};
        int target4 = 0;
        int[] result4 = solver.twoSum(nums4, target4);
        System.out.println("\nTest Case 4: nums = [0, 4, 3, 0], target = 0");
        if (result4.length == 2) {
            System.out.println("Result indices: [" + result4[0] + ", " + result4[1] + "]"); // Expected: [0, 3]
        } else {
            System.out.println("No pair found.");
        }
        // Honestly, tried brute force O(N^2) first. This HashMap approach is way cleaner and faster for larger inputs.
    }
}