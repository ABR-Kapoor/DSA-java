class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class DiameterOfBTree {
    // This variable will store the maximum diameter found anywhere in the tree.
    // It's effectively a global variable for the recursive calls, kinda like a state shared during DP.
    private int maxDiameter = 0;

    /**
     * Calculates the diameter of a binary tree.
     * The diameter is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root.
     *
     * @param root The root node of the binary tree.
     * @return The diameter of the binary tree.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // Reset maxDiameter for each new tree calculation.
        // This is crucial if this method is called multiple times with different trees.
        maxDiameter = 0;
        // Start the recursive helper function which computes height and updates diameter.
        calculateHeightAndDiameter(root);
        return maxDiameter;
    }

    /**
     * A recursive helper function that calculates the height of the subtree rooted at 'node'
     * and simultaneously updates the 'maxDiameter' global variable.
     * This is the "bottom-up DP" part: child heights are computed first,
     * then used to determine the current node's height and potential diameter.
     *
     * @param node The current node being processed.
     * @return The height of the subtree rooted at 'node' (number of edges from 'node' to its deepest leaf).
     */
    private int calculateHeightAndDiameter(TreeNode node) {
        // Base case: A null node means no edges, so its "height" is -1.
        // This convention makes calculations for leaf nodes simpler (leaf height becomes 0).
        if (node == null) {
            return -1;
        }

        // Recursively get the heights of the left and right subtrees.
        // This follows a post-order traversal pattern, processing children before the parent.
        int leftSubtreeHeight = calculateHeightAndDiameter(node.left);
        int rightSubtreeHeight = calculateHeightAndDiameter(node.right);

        // The diameter *passing through* the current 'node' is the sum of the longest paths
        // from its left and right children to their deepest leaves, plus the two edges
        // connecting the current node to its children.
        // This translates to (leftSubtreeHeight + rightSubtreeHeight + 2) edges.
        // This is where the magic happens for bottom-up calculation! We update the global max as we go.
        maxDiameter = Math.max(maxDiameter, leftSubtreeHeight + rightSubtreeHeight + 2);

        // The height of the current node's subtree is 1 (for the edge from current node to its tallest child)
        // plus the maximum height of its children's subtrees.
        // Recursive calls make this natural for trees, avoids explicit stack management.
        // O(N) time because each node is visited once. Space is O(H) for recursion stack, acceptable for now.
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }

    // Main method for testing the DiameterOfBTree class
    public static void main(String[] args) {
        DiameterOfBTree solver = new DiameterOfBTree();

        // Test Case 1: Standard tree with a diameter not necessarily through the root
        //   1
        //  / \
        // 2   3
        // / \
        // 4   5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Test Case 1: Tree: [1,2,3,4,5] (Path: 4-2-1-3 or 5-2-1-3)");
        System.out.println("Expected Diameter: 3");
        System.out.println("Result: " + solver.diameterOfBinaryTree(root1)); // Expect 3

        // Test Case 2: Skewed tree (left-sided)
        //   1
        //  /
        // 2
        // /
        // 3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        System.out.println("\nTest Case 2: Tree: [1,2,null,3] (Path: 3-2-1)");
        System.out.println("Expected Diameter: 2");
        System.out.println("Result: " + solver.diameterOfBinaryTree(root2)); // Expect 2

        // Test Case 3: Empty tree (edge case)
        System.out.println("\nTest Case 3: Empty Tree");
        System.out.println("Expected Diameter: 0"); // Corner case: A null root correctly yields 0 diameter.
        System.out.println("Result: " + solver.diameterOfBinaryTree(null)); // Expect 0

        // Test Case 4: Single node tree
        TreeNode root4 = new TreeNode(1);
        System.out.println("\nTest Case 4: Single Node Tree: [1]");
        System.out.println("Expected Diameter: 0");
        System.out.println("Result: " + solver.diameterOfBinaryTree(root4)); // Expect 0

        // Test Case 5: Another complex tree
        //       4
        //      / \
        //     2   7
        //    / \   \
        //   1   3   9
        //            /
        //           8
        TreeNode root5 = new TreeNode(4);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(7);
        root5.left.left = new TreeNode(1);
        root5.left.right = new TreeNode(3);
        root5.right.right = new TreeNode(9);
        root5.right.right.left = new TreeNode(8);
        System.out.println("\nTest Case 5: Tree: [4,2,7,1,3,null,9,null,null,null,null,8]"); // Path 1-2-4-7-9-8 (length 5)
        System.out.println("Expected Diameter: 5");
        System.out.println("Result: " + solver.diameterOfBinaryTree(root5)); // Expect 5
    }
}