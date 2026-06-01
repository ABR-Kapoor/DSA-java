import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelOrderTraversal {

    // This is how I usually define TreeNode for these problems.
    // Making it static so main can access it easily without an outer class instance.
    static class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // Handling null root is crucial, otherwise, we'd get a NullPointerException right at the start.
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Add the root node to start

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            List<Integer> currentLevelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevelNodes);
            // This queue is key to level-order. FIFO ensures we process nodes level by level.
        }
        // The space complexity is O(W) where W is the maximum width of the tree,
        // which can be O(N) in the worst case (e.g., a complete binary tree). Acceptable for now.
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal solver = new LevelOrderTraversal();

        System.out.println("--- Level Order Traversal Test Cases ---");

        // Test Case 1: A typical balanced binary tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Tree 1 (3, 9, 20, 15, 7): " + solver.levelOrder(root1));
        // Expected Output: [[3], [9, 20], [15, 7]]

        // Test Case 2: A single node tree
        TreeNode root2 = new TreeNode(1);
        System.out.println("Tree 2 (1): " + solver.levelOrder(root2));
        // Expected Output: [[1]]

        // Test Case 3: An empty tree
        TreeNode root3 = null;
        System.out.println("Tree 3 (Empty): " + solver.levelOrder(root3));
        // Expected Output: []

        // Test Case 4: A skewed tree (left-heavy)
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.left.left = new TreeNode(4);
        System.out.println("Tree 4 (1, 2, 3, 4 left-skewed): " + solver.levelOrder(root4));
        // Expected Output: [[1], [2], [3], [4]]

        // Test Case 5: Another tree, slightly more complex
        TreeNode root5 = new TreeNode(10);
        root5.left = new TreeNode(5);
        root5.right = new TreeNode(15);
        root5.left.left = new TreeNode(2);
        root5.left.right = new TreeNode(7);
        root5.right.left = new TreeNode(12); // Added another node
        root5.right.right = new TreeNode(20);
        System.out.println("Tree 5 (10, 5, 15, 2, 7, 12, 20): " + solver.levelOrder(root5));
        // Expected Output: [[10], [5, 15], [2, 7, 12, 20]]
    }
}