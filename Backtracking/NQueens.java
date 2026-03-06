import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class NQueens {

    /**
     * Solves the N-Queens problem and returns all distinct solutions.
     * Each solution is a list of strings, where each string represents a row of the board.
     * 'Q' denotes a queen and '.' denotes an empty space.
     *
     * @param n The size of the chessboard (N x N).
     * @return A list of all solutions.
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        if (n <= 0) { // this edge case tripped me up - an empty board means no queens can be placed
            return solutions;
        }

        // 'queens' array stores the column position of the queen for each row.
        // queens[i] = j means a queen is placed at (row i, column j).
        int[] queens = new int[n];
        Arrays.fill(queens, -1); // Initialize with -1 to indicate no queen placed yet in that row.

        // Start the backtracking process from the first row (row 0).
        backtrack(n, 0, queens, solutions);
        return solutions;
    }

    /**
     * Recursive helper function for backtracking.
     * Tries to place a queen in the current 'row' and recursively calls itself for the next row.
     *
     * @param n         The size of the chessboard.
     * @param row       The current row to place a queen.
     * @param queens    The array storing queen placements.
     * @param solutions The list to collect all valid board configurations.
     */
    private void backtrack(int n, int row, int[] queens, List<List<String>> solutions) {
        // Base case: If all rows have queens placed successfully, a solution is found.
        if (row == n) {
            solutions.add(constructBoard(n, queens));
            return;
        }

        // Iterate through each column in the current row to try placing a queen.
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col; // Place the queen at (row, col)
                backtrack(n, row + 1, queens, solutions); // Move to the next row
                queens[row] = -1; // Backtrack: Remove the queen (reset for other possibilities in current row)
            }
        }
    }

    /**
     * Checks if placing a queen at (row, col) is safe from previously placed queens.
     * A queen is safe if no other queen is in the same column or on the same diagonal.
     *
     * @param row    The current row for the new queen.
     * @param col    The current column for the new queen.
     * @param queens The array of previously placed queens.
     * @return True if safe, false otherwise.
     */
    private boolean isSafe(int row, int col, int[] queens) {
        // Check only previously placed queens (rows 0 to row-1).
        // No need to check rows >= current 'row' as they don't have queens yet.
        // O(N) space for the 'queens' array and recursion stack, acceptable for board sizes where N-Queens is typically solved.
        for (int i = 0; i < row; i++) {
            // Check if same column: queens[i] == col
            // Check if same diagonal: Math.abs(queens[i] - col) == Math.abs(i - row)
            // Using an int[] for queen positions is much cleaner than a char[][] for the board state.
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false; // Not safe
            }
        }
        return true; // Safe to place queen
    }

    /**
     * Converts the queen placement array into a list of strings representing the board.
     *
     * @param n      The size of the chessboard.
     * @param queens The array of queen placements.
     * @return A list of strings, each representing a row of the board.
     */
    private List<String> constructBoard(int n, int[] queens) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] rowChars = new char[n];
            Arrays.fill(rowChars, '.'); // Fill current row with empty spaces
            if (queens[i] != -1) { // If a queen is placed in this row
                rowChars[queens[i]] = 'Q'; // Place 'Q' at its column
            }
            board.add(new String(rowChars));
        }
        return board;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();

        System.out.println("--- N-Queens for N=4 ---");
        List<List<String>> solutions4 = solver.solveNQueens(4);
        if (solutions4.isEmpty()) {
            System.out.println("No solutions found for N=4.");
        } else {
            System.out.println("Found " + solutions4.size() + " solutions:");
            for (int i = 0; i < solutions4.size(); i++) {
                System.out.println("Solution " + (i + 1) + ":");
                for (String row : solutions4.get(i)) {
                    System.out.println(row);
                }
                System.out.println(); // Separator between solutions
            }
        }
        System.out.println("------------------------\n");

        System.out.println("--- N-Queens for N=1 ---");
        List<List<String>> solutions1 = solver.solveNQueens(1);
        if (solutions1.isEmpty()) {
            System.out.println("No solutions found for N=1.");
        } else {
            System.out.println("Found " + solutions1.size() + " solution:");
            for (String row : solutions1.get(0)) { // Only one solution for N=1
                System.out.println(row);
            }
        }
        System.out.println("------------------------\n");

        System.out.println("--- N-Queens for N=8 (first 2 solutions only) ---");
        List<List<String>> solutions8 = solver.solveNQueens(8);
        if (solutions8.isEmpty()) {
            System.out.println("No solutions found for N=8.");
        } else {
            System.out.println("Total solutions for N=8: " + solutions8.size());
            // Only print a couple of solutions for N=8 as it can be very long
            int count = 0;
            for (List<String> solution : solutions8) {
                if (count >= 2) break; // Print only first 2 solutions
                System.out.println("Solution " + (count + 1) + ":");
                for (String row : solution) {
                    System.out.println(row);
                }
                System.out.println();
                count++;
            }
            if (solutions8.size() > 2) {
                System.out.println("...and " + (solutions8.size() - 2) + " more solutions.");
            }
        }
        System.out.println("------------------------------------------------\n");
    }
}