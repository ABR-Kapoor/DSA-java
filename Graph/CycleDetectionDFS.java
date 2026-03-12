import java.util.ArrayList;
import java.util.List;

class CycleDetectionDFS {

    /**
     * Checks if a directed graph contains any cycles using DFS.
     *
     * @param numVertices The number of vertices in the graph.
     * @param adjList     The adjacency list representation of the graph.
     * @return true if a cycle is found, false otherwise.
     */
    public boolean hasCycle(int numVertices, List<List<Integer>> adjList) {
        if (numVertices == 0) { // this edge case tripped me up — an empty graph has no cycles
            return false;
        }

        boolean[] visited = new boolean[numVertices];
        boolean[] pathStack = new boolean[numVertices]; // pathStack[] is key: tracks nodes in *current* DFS path, not just visited overall.

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                if (dfsCheck(i, adjList, visited, pathStack)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle found in any component
    }

    /**
     * Recursive helper for DFS-based cycle detection.
     *
     * @param u          The current vertex being visited.
     * @param adjList    The adjacency list of the graph.
     * @param visited    Array to track all visited vertices.
     * @param pathStack  Array to track vertices in the current DFS recursion stack.
     * @return true if a cycle is detected from this path, false otherwise.
     */
    private boolean dfsCheck(int u, List<List<Integer>> adjList, boolean[] visited, boolean[] pathStack) {
        visited[u] = true;
        pathStack[u] = true; // Add current node to recursion stack. O(V) space for these boolean arrays and recursion stack, acceptable for small to medium graphs.

        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                if (dfsCheck(v, adjList, visited, pathStack)) {
                    return true; // Cycle found in a deeper path
                }
            } else if (pathStack[v]) { // If neighbor 'v' is already in current pathStack
                // This means we found a back-edge to an ancestor in the current DFS path
                return true; // Cycle detected!
            }
        }
        
        pathStack[u] = false; // Backtrack: Remove current node from recursion stack. Forgot to reset pathStack[u] to false initially; kept getting cycles in DAGs. Classic mistake.
        return false; // No cycle from this path
    }

    // Main method to test the cycle detection
    public static void main(String[] args) {
        // Test case 1: Graph with a cycle (0 -> 1 -> 2 -> 0)
        int V1 = 4;
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < V1; i++) {
            adj1.add(new ArrayList<>());
        }
        adj1.get(0).add(1);
        adj1.get(1).add(2);
        adj1.get(2).add(0); 
        adj1.get(2).add(3);
        adj1.get(3).add(3); // Self-loop cycle

        CycleDetectionDFS detector1 = new CycleDetectionDFS();
        System.out.println("Graph 1 has a cycle: " + detector1.hasCycle(V1, adj1)); // Expected: true

        // Test case 2: Graph without a cycle (DAG)
        int V2 = 4;
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) {
            adj2.add(new ArrayList<>());
        }
        adj2.get(0).add(1);
        adj2.get(0).add(2);
        adj2.get(1).add(3);
        adj2.get(2).add(3);

        CycleDetectionDFS detector2 = new CycleDetectionDFS();
        System.out.println("Graph 2 has a cycle: " + detector2.hasCycle(V2, adj2)); // Expected: false

        // Test case 3: Disconnected graph with a cycle in one component
        int V3 = 5;
        List<List<Integer>> adj3 = new ArrayList<>();
        for (int i = 0; i < V3; i++) {
            adj3.add(new ArrayList<>());
        }
        adj3.get(0).add(1);
        adj3.get(1).add(2);
        adj3.get(2).add(0); // Cycle: 0 -> 1 -> 2 -> 0
        adj3.get(3).add(4);

        CycleDetectionDFS detector3 = new CycleDetectionDFS();
        System.out.println("Graph 3 has a cycle: " + detector3.hasCycle(V3, adj3)); // Expected: true
        
        // Test case 4: Graph with no edges
        int V4 = 3;
        List<List<Integer>> adj4 = new ArrayList<>();
        for (int i = 0; i < V4; i++) {
            adj4.add(new ArrayList<>());
        }
        CycleDetectionDFS detector4 = new CycleDetectionDFS();
        System.out.println("Graph 4 has a cycle: " + detector4.hasCycle(V4, adj4)); // Expected: false

        // Test case 5: Empty graph
        int V5 = 0;
        List<List<Integer>> adj5 = new ArrayList<>(); // Adjacency list will remain empty
        CycleDetectionDFS detector5 = new CycleDetectionDFS();
        System.out.println("Graph 5 (empty) has a cycle: " + detector5.hasCycle(V5, adj5)); // Expected: false
    }
}