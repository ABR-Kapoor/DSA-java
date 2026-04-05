import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allSolutions = new ArrayList<>();
        if (n <= 0) { // this edge case tripped me up — N <= 0 must return empty list
            return allSolutions;
        }

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.'); // Initializing board with '.' simplifies print logic later.
        }

        backtrack(board, 0, allSolutions, n);
        return allSolutions;
    }

    private void backtrack(char[][] board, int col, List<List<String>> allSolutions, int n) {
        // Base case: All queens are placed (we've successfully placed a queen in each column)
        if (col == n) {
            allSolutions.add(convertBoardToList(board));
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < n; row++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q'; // Place queen
                backtrack(board, col + 1, allSolutions, n); // Recurse for the next column
                board[row][col] = '.'; // Backtrack: remove queen
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // Check row to the left
        for (int c = 0; c < col; c++) {
            if (board[row][c] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        // This part for checking diagonals was tricky, almost forgot both directions!
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Check lower-left diagonal
        for (int r = row + 1, c = col - 1; r < n && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> convertBoardToList(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();

        // Test Case 1: N = 4
        int n1 = 4;
        System.out.println("N = " + n1 + " Solutions:");
        List<List<String>> solutions1 = solver.solveNQueens(n1);
        for (List<String> sol : solutions1) {
            for (String s : sol) {
                System.out.println(s);
            }
            System.out.println(); // Separate solutions with an empty line
        }
        System.out.println("Total solutions for N=" + n1 + ": " + solutions1.size());
        System.out.println("--------------------");

        // Test Case 2: N = 1
        int n2 = 1;
        System.out.println("N = " + n2 + " Solutions:");
        List<List<String>> solutions2 = solver.solveNQueens(n2);
        for (List<String> sol : solutions2) {
            for (String s : sol) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println("Total solutions for N=" + n2 + ": " + solutions2.size());
        System.out.println("--------------------");

        // Test Case 3: N = 8 (This might take a bit for larger N, but should run)
        int n3 = 8;
        System.out.println("N = " + n3 + " Solutions (displaying only count):");
        List<List<String>> solutions3 = solver.solveNQueens(n3);
        // O(N) space because of the recursion stack, acceptable for typical N-Queens where N is small.
        System.out.println("Total solutions for N=" + n3 + ": " + solutions3.size());
        System.out.println("--------------------");

        // Test Case 4: N = 0 (Edge case)
        int n4 = 0;
        System.out.println("N = " + n4 + " Solutions:");
        List<List<String>> solutions4 = solver.solveNQueens(n4);
        System.out.println("Total solutions for N=" + n4 + ": " + solutions4.size());
        System.out.println("--------------------");
    }
}