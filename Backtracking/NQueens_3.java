class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allSolutions = new ArrayList<>();
        if (n <= 0) { // this edge case tripped me up — empty array must return empty list, not null
            return allSolutions;
        }

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Flags to track occupied columns, main diagonals, and anti-diagonals
        // My initial thought was to use lists to track occupied positions, but boolean arrays are more efficient for O(1) lookups.
        boolean[] colOccupied = new boolean[n];
        boolean[] mainDiagOccupied = new boolean[2 * n - 1]; // r - c + n - 1
        boolean[] antiDiagOccupied = new boolean[2 * n - 1]; // r + c

        backtrack(0, n, board, colOccupied, mainDiagOccupied, antiDiagOccupied, allSolutions);
        return allSolutions;
    }

    private void backtrack(int row, int n, char[][] board,
                           boolean[] colOccupied, boolean[] mainDiagOccupied, boolean[] antiDiagOccupied,
                           List<List<String>> allSolutions) {

        if (row == n) {
            allSolutions.add(convertBoardToList(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            // Check if current position (row, col) is safe
            // O(N) space for the booleans here, acceptable for now
            if (!colOccupied[col] &&
                !mainDiagOccupied[row - col + n - 1] &&
                !antiDiagOccupied[row + col]) {

                // Place queen
                board[row][col] = 'Q';
                colOccupied[col] = true;
                mainDiagOccupied[row - col + n - 1] = true;
                antiDiagOccupied[row + col] = true;

                // Recurse for the next row
                backtrack(row + 1, n, board, colOccupied, mainDiagOccupied, antiDiagOccupied, allSolutions);

                // Backtrack: Remove queen and reset flags
                board[row][col] = '.';
                colOccupied[col] = false;
                mainDiagOccupied[row - col + n - 1] = false;
                antiDiagOccupied[row + col] = false;
            }
        }
    }

    private List<String> convertBoardToList(char[][] board) {
        List<String> solution = new ArrayList<>();
        // Building the board string by string at the end makes sense; avoids complex char[][] to List<String> conversions mid-backtrack.
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();

        // Test Case 1: n = 4 (Expected: 2 solutions)
        int n1 = 4;
        List<List<String>> solutions1 = solver.solveNQueens(n1);
        System.out.println("Solutions for N = " + n1 + ":");
        for (List<String> solution : solutions1) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println(); // Separator between solutions
        }
        System.out.println("Total solutions: " + solutions1.size());
        System.out.println("--------------------");

        // Test Case 2: n = 1 (Expected: 1 solution)
        int n2 = 1;
        List<List<String>> solutions2 = solver.solveNQueens(n2);
        System.out.println("Solutions for N = " + n2 + ":");
        for (List<String> solution : solutions2) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        System.out.println("Total solutions: " + solutions2.size());
        System.out.println("--------------------");

        // Test Case 3: n = 3 (Expected: 0 solutions)
        int n3 = 3;
        List<List<String>> solutions3 = solver.solveNQueens(n3);
        System.out.println("Solutions for N = " + n3 + ":");
        for (List<String> solution : solutions3) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        System.out.println("Total solutions: " + solutions3.size());
        System.out.println("--------------------");
        
        // Test Case 4: n = 0 (Expected: 0 solutions, handled by base case)
        int n4 = 0;
        List<List<String>> solutions4 = solver.solveNQueens(n4);
        System.out.println("Solutions for N = " + n4 + ":");
        System.out.println("Total solutions: " + solutions4.size());
        System.out.println("--------------------");
    }
}