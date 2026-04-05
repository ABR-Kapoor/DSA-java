class KnapsackZeroOne {

    /**
     * Solves the 0/1 Knapsack problem using tabulation (dynamic programming).
     * Given weights and profits of N items, put them in a knapsack of capacity W
     * to get the maximum total profit. Each item can only be included once.
     *
     * @param profits  An array containing the profit of each item.
     * @param weights  An array containing the weight of each item.
     * @param capacity The maximum weight capacity of the knapsack.
     * @return The maximum total profit that can be achieved.
     */
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // Handle invalid inputs.
        // this edge case tripped me up — empty array or zero capacity should return 0 profit.
        // Returning 0 as max profit possible with no items or invalid input.
        if (capacity <= 0 || profits == null || weights == null || profits.length != weights.length) {
            return 0;
        }

        int numItems = profits.length;
        
        // dp[i][c] will store the maximum profit that can be obtained
        // from the first 'i' items with 'c' capacity.
        // We use numItems + 1 and capacity + 1 to account for 0-indexed items and capacity.
        int[][] dp = new int[numItems + 1][capacity + 1];

        // Fill the dp table
        // 'i' iterates through the number of items considered (from 1 to numItems)
        for (int i = 1; i <= numItems; i++) {
            // 'c' iterates through the current knapsack capacity (from 1 to 'capacity')
            for (int c = 1; c <= capacity; c++) {
                // Get the profit and weight of the current item.
                // Note: profits/weights arrays are 0-indexed, so item 'i' corresponds to index 'i-1'.
                int currentItemProfit = profits[i - 1];
                int currentItemWeight = weights[i - 1];

                // Option 1: Don't include the current item.
                // The profit is simply the profit obtained with 'i-1' items and the same 'c' capacity.
                int profitWithoutCurrentItem = dp[i - 1][c];

                // Option 2: Include the current item, if it fits within the current capacity 'c'.
                int profitWithCurrentItem = 0;
                if (currentItemWeight <= c) {
                    // Profit is current item's profit PLUS the max profit from 'i-1' items
                    // using the remaining capacity (c - currentItemWeight).
                    profitWithCurrentItem = currentItemProfit + dp[i - 1][c - currentItemWeight];
                }
                
                // The max profit for dp[i][c] is the maximum of these two options.
                dp[i][c] = Math.max(profitWithoutCurrentItem, profitWithCurrentItem);
            }
        }
        // tried recursive first but iterative is cleaner here, avoiding potential stack overflow for large inputs.
        // O(numItems * capacity) space for the dp table, which is acceptable for typical constraints.
        return dp[numItems][capacity];
    }

    public static void main(String[] args) {
        KnapsackZeroOne ks = new KnapsackZeroOne();

        System.out.println("--- 0/1 Knapsack Tabulation Test Cases ---");

        // Test Case 1: Standard example
        int[] profits1 = {1, 6, 10, 16};
        int[] weights1 = {1, 2, 3, 5};
        int capacity1 = 7;
        System.out.println("Test Case 1 (Capacity " + capacity1 + "):");
        System.out.println("   Profits: {1, 6, 10, 16}, Weights: {1, 2, 3, 5}");
        System.out.println("   Max profit = " + ks.solveKnapsack(profits1, weights1, capacity1)); // Expected: 22 (items with weights 2 and 5)
        System.out.println("----------------------------------------");

        // Test Case 2: Different set of items and capacity
        int[] profits2 = {4, 5, 1};
        int[] weights2 = {2, 3, 1};
        int capacity2 = 4;
        System.out.println("Test Case 2 (Capacity " + capacity2 + "):");
        System.out.println("   Profits: {4, 5, 1}, Weights: {2, 3, 1}");
        System.out.println("   Max profit = " + ks.solveKnapsack(profits2, weights2, capacity2)); // Expected: 6 (items with weights 3 and 1)
        System.out.println("----------------------------------------");

        // Test Case 3: Empty input arrays
        int[] profits3 = {};
        int[] weights3 = {};
        int capacity3 = 10;
        System.out.println("Test Case 3 (Empty arrays, Capacity " + capacity3 + "):");
        System.out.println("   Profits: {}, Weights: {}");
        System.out.println("   Max profit = " + ks.solveKnapsack(profits3, weights3, capacity3)); // Expected: 0
        System.out.println("----------------------------------------");

        // Test Case 4: No items fit into the knapsack
        int[] profits4 = {100, 200};
        int[] weights4 = {10, 20};
        int capacity4 = 5;
        System.out.println("Test Case 4 (No items fit, Capacity " + capacity4 + "):");
        System.out.println("   Profits: {100, 200}, Weights: {10, 20}");
        System.out.println("   Max profit = " + ks.solveKnapsack(profits4, weights4, capacity4)); // Expected: 0
        System.out.println("----------------------------------------");

        // Test Case 5: Zero capacity knapsack
        int[] profits5 = {10, 20};
        int[] weights5 = {1, 2};
        int capacity5 = 0;
        System.out.println("Test Case 5 (Zero capacity, Capacity " + capacity5 + "):");
        System.out.println("   Profits: {10, 20}, Weights: {1, 2}");
        System.out.println("   Max profit = " + ks.solveKnapsack(profits5, weights5, capacity5)); // Expected: 0
        System.out.println("----------------------------------------");
    }
}