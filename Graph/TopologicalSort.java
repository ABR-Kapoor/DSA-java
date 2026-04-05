import java.util.*;

class TopologicalSort {

    /**
     * Performs a topological sort on a directed acyclic graph (DAG) using Kahn's algorithm (BFS).
     *
     * @param numNodes The total number of nodes in the graph. Nodes are 0-indexed.
     * @param edges An array of integer arrays, where each inner array [u, v] represents a directed edge from u to v.
     * @return A list of integers representing one possible topological ordering of the nodes.
     *         Returns an empty list if numNodes is 0 or if a cycle is detected.
     */
    public List<Integer> topologicalSort(int numNodes, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (numNodes <= 0) {
            return result; // Empty graph, empty sort.
        }

        // Adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Array to store in-degrees of each node
        int[] inDegree = new int[numNodes];

        // Populate adjacency list and in-degrees
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        // Queue for BFS, storing nodes with 0 in-degree
        Queue<Integer> q = new LinkedList<>();
        // Initially considered DFS, but Kahn's BFS is often simpler to implement for cycle detection.
        for (int i = 0; i < numNodes; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // To count processed nodes, helps detect cycles
        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);
            count++;

            // For each neighbor v of u, decrement its in-degree
            // If v's in-degree becomes 0, add it to the queue
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }

        // A common pitfall: if 'count' doesn't match numNodes, there's a cycle. Important check.
        // O(V+E) for adj list and in-degree array, plus queue space. Acceptable for most graphs.
        if (count != numNodes) {
            // Cycle detected, topological sort not possible. Return empty or indicate failure.
            // For now, returning an incomplete list is also a valid signal for student code.
            // But a true result should have all nodes if no cycle.
            return new ArrayList<>(); // Return empty list to explicitly signal a cycle
        }

        return result;
    }

    public static void main(String[] args) {
        TopologicalSort sorter = new TopologicalSort();

        System.out.println("--- Test Case 1: Simple DAG ---");
        int numNodes1 = 4;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 1}};
        List<Integer> result1 = sorter.topologicalSort(numNodes1, edges1);
        System.out.println("Nodes: " + numNodes1 + ", Edges: " + Arrays.deepToString(edges1));
        System.out.println("Topological Order: " + result1); // Expected: [0, 3, 1, 2] or [3, 0, 1, 2]

        System.out.println("\n--- Test Case 2: Larger DAG with multiple starting points ---");
        int numNodes2 = 6;
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 5}};
        List<Integer> result2 = sorter.topologicalSort(numNodes2, edges2);
        System.out.println("Nodes: " + numNodes2 + ", Edges: " + Arrays.deepToString(edges2));
        System.out.println("Topological Order: " + result2); // Expected: [0, 1, 2, 3, 4, 5] (one possible order)

        System.out.println("\n--- Test Case 3: Graph with a cycle ---");
        int numNodes3 = 3;
        int[][] edges3 = {{0, 1}, {1, 2}, {2, 0}}; // Cycle: 0 -> 1 -> 2 -> 0
        List<Integer> result3 = sorter.topologicalSort(numNodes3, edges3);
        System.out.println("Nodes: " + numNodes3 + ", Edges: " + Arrays.deepToString(edges3));
        System.out.println("Topological Order: " + result3); // Expected: [] (empty list due to cycle)

        System.out.println("\n--- Test Case 4: Empty graph (numNodes = 0) ---");
        int numNodes4 = 0;
        int[][] edges4 = {};
        List<Integer> result4 = sorter.topologicalSort(numNodes4, edges4);
        System.out.println("Nodes: " + numNodes4 + ", Edges: " + Arrays.deepToString(edges4));
        System.out.println("Topological Order: " + result4); // Expected: []

        System.out.println("\n--- Test Case 5: Graph with no edges ---");
        int numNodes5 = 3;
        int[][] edges5 = {};
        List<Integer> result5 = sorter.topologicalSort(numNodes5, edges5);
        System.out.println("Nodes: " + numNodes5 + ", Edges: " + Arrays.deepToString(edges5));
        System.out.println("Topological Order: " + result5); // Expected: [0, 1, 2] (order doesn't matter without edges)
    }
}