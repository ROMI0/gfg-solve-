import java.util.*;

class Solution {
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        // Check if all non-zero degree vertices are connected
        if (!isConnected(adj, V)) {
            return 0;
        }

        // Count vertices with odd degree
        int oddDegreeCount = 0;
        for (int i = 0; i < V; i++) {
            if (adj[i].size() % 2 != 0) {
                oddDegreeCount++;
            }
        }

        // If count is 2, return 1 (eulerian path), if count is 0, return 2 (eulerian circuit), else return 0
        return (oddDegreeCount == 0) ? 2 : (oddDegreeCount == 2) ? 1 : 0;
    }

    // Function to check if all non-zero degree vertices are connected
    private boolean isConnected(List<Integer>[] adj, int V) {
        boolean[] visited = new boolean[V];
        int nonZeroDegreeVertex = -1;

        // Find the first non-zero degree vertex
        for (int i = 0; i < V; i++) {
            if (adj[i].size() > 0) {
                nonZeroDegreeVertex = i;
                break;
            }
        }

        // If there are no edges, return true
        if (nonZeroDegreeVertex == -1) {
            return true;
        }

        // Perform DFS to check connectivity
        dfs(adj, nonZeroDegreeVertex, visited);

        // Check if all non-zero degree vertices are visited
        for (int i = 0; i < V; i++) {
            if (adj[i].size() > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    // Helper function for DFS
    private void dfs(List<Integer>[] adj, int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int neighbor : adj[vertex]) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}
