// Definition for a binary tree node.
// This is a common setup for tree problems in competitive programming.
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

// Main class to solve the Diameter of Binary Tree problem.
// This uses a recursive approach, which implicitly works bottom-up to calculate heights and diameter.
class DiameterOfBTree {
    // A global variable to keep track of the maximum diameter found across all subtrees.
    // Initialized to 0, as an empty tree or single-node tree has 0 diameter.
    int maxDiameter = 0;

    /**
     * Helper function that calculates the height of a subtree and,
     * in the process, updates the global maxDiameter.
     * This recursive approach calculates height efficiently, also updates max diameter in a single pass. Clean stuff.
     *
     * @param node The current node being processed.
     * @return The height of the subtree rooted at 'node'.
     */
    private int calculateHeight(TreeNode node) {
        // Base case: If the node is null, its height is 0.
        if (node == null) {
            return 0;
        }

        // Recursively determine the height of the left and right subtrees.
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // The diameter passing through the current node would be the sum of heights
        // of its left and right subtrees. Update the global max if this is greater.
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // The height of the current subtree is 1 (for the current node itself)
        // plus the maximum height of its children.
        // Stack space is O(h) where h is tree height, worst case O(N) for skewed trees. Acceptable for now.
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Calculates the diameter of the given binary tree.
     * The diameter is defined as the length of the longest path between any two nodes.
     * This path doesn't necessarily have to pass through the root.
     *
     * @param root The root node of the binary tree.
     * @return The calculated diameter of the binary tree.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // Reset maxDiameter for each new tree calculation. Important if the solver object is reused.
        maxDiameter = 0;
        // Initiate the recursive height calculation from the root.
        // The return value of calculateHeight is not directly used here,
        // as maxDiameter is updated as a side effect (globally).
        calculateHeight(root);
        return maxDiameter;
    }

    public static void main(String[] args) {
        DiameterOfBTree solver = new DiameterOfBTree();

        // Test Case 1: Standard example tree
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right = new TreeNode(3);
        System.out.println("Diameter of Tree 1: " + solver.diameterOfBinaryTree(root1)); // Expected: 3 (e.g., path 4-2-1-3 or 5-2-1-3)

        // Test Case 2: Simple tree with a single left child
        //   1
        //  /
        // 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println("Diameter of Tree 2: " + solver.diameterOfBinaryTree(root2)); // Expected: 1 (path 2-1)

        // Test Case 3: Empty tree
        // This edge case often gets tricky: null root means 0 diameter, not some arbitrary negative.
        TreeNode root3 = null;
        System.out.println("Diameter of Tree 3 (empty): " + solver.diameterOfBinaryTree(root3)); // Expected: 0

        // Test Case 4: Single node tree
        TreeNode root4 = new TreeNode(10);
        System.out.println("Diameter of Tree 4 (single node): " + solver.diameterOfBinaryTree(root4)); // Expected: 0

        // Test Case 5: A longer, skewed tree to thoroughly test path length
        //      1
        //     /
        //    2
        //   /
        //  3
        // /
        //4
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.left.left = new TreeNode(3);
        root5.left.left.left = new TreeNode(4);
        System.out.println("Diameter of Tree 5 (skewed): " + solver.diameterOfBinaryTree(root5)); // Expected: 3 (path 4-3-2-1)
    }
}