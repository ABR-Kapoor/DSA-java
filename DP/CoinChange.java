class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // dp[i] will store the minimum number of coins needed to make amount i.
        // Initialize with amount + 1, effectively "infinity", as max coins needed can't exceed amount itself (if using 1-unit coins).
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // Base case: 0 coins needed for amount 0
        dp[0] = 0;

        // Iterate through all possible amounts from 1 up to the target amount
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            // For each amount, iterate through all available coins
            for (int coin : coins) {
                // If the current coin can be used without going into negative amount
                if (currentAmount - coin >= 0) {
                    // Update dp[currentAmount] with the minimum of its current value
                    // and 1 (for the current coin) + dp value for the remaining amount.
                    dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[currentAmount - coin]);
                }
            }
        }

        // If dp[amount] is still amount + 1, it means the amount is unreachable
        // tried recursive first but iterative is cleaner here, avoiding stack overflow for large amounts.
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();

        // Test case 1: Standard case
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        // Expected: 3 (5 + 5 + 1)
        System.out.println("Coins: {1, 2, 5}, Amount: 11 -> Min coins: " + solver.coinChange(coins1, amount1));

        // Test case 2: No solution
        int[] coins2 = {2};
        int amount2 = 3;
        // Expected: -1
        System.out.println("Coins: {2}, Amount: 3 -> Min coins: " + solver.coinChange(coins2, amount2));

        // Test case 3: Amount is 0
        int[] coins3 = {1};
        int amount3 = 0;
        // Expected: 0
        System.out.println("Coins: {1}, Amount: 0 -> Min coins: " + solver.coinChange(coins3, amount3)); // this edge case tripped me up — amount 0 must return 0

        // Test case 4: Larger values, multiple coins
        int[] coins4 = {186,419,83,408};
        int amount4 = 6249;
        // Expected: 20
        System.out.println("Coins: {186,419,83,408}, Amount: 6249 -> Min coins: " + solver.coinChange(coins4, amount4)); // O(N) space for DP table, acceptable for now, no complex data structures.
    }
}