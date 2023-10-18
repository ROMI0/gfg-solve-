class Solution {
    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<Integer> safeNodes = new ArrayList<>();
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            if (dfs(i, adj, color)) {
                safeNodes.add(i);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    private boolean dfs(int node, List<List<Integer>> adj, int[] color) {
        if (color[node] == 1) {
            return true; // Visited and found to be safe.
        }
        if (color[node] == 2) {
            return false; // Visited and found to be unsafe.
        }

        color[node] = 2; // Mark as visited and potentially unsafe.

        for (int neighbor : adj.get(node)) {
            if (!dfs(neighbor, adj, color)) {
                return false; // If any neighbor is found to be unsafe, the current node is also unsafe.
            }
        }

        color[node] = 1; // Mark as visited and safe.
        return true;
    }
}

