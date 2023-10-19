class Solution {
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];

        queue.offer(0); // Start from node 0.
        visited[0] = true;

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();

                if (currentNode == X) {
                    return level; // Found the node, return its level.
                }

                // Explore neighbors of the current node.
                for (int neighbor : adj.get(currentNode)) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }

            level++; // Move to the next level.
        }

        // If X is not found, return -1.
        return -1;
    }
}
