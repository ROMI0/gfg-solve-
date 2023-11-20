class Solution {
    public int sumK(Node root, int k) {
        if (root == null) {
            return 0;
        }

        int[] result = new int[1];
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // To handle paths starting from the root

        countPaths(root, 0, k, prefixSumCount, result);

        return result[0];
    }

    private void countPaths(Node node, int currentSum, int targetSum, Map<Integer, Integer> prefixSumCount, int[] result) {
        if (node == null) {
            return;
        }

        currentSum += node.data;

        // Count the number of paths with the desired sum
        if (prefixSumCount.containsKey(currentSum - targetSum)) {
            result[0] += prefixSumCount.get(currentSum - targetSum);
        }

        // Update the prefix sum count
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Recursively traverse the left and right subtrees
        countPaths(node.left, currentSum, targetSum, prefixSumCount, result);
        countPaths(node.right, currentSum, targetSum, prefixSumCount, result);

        // Remove the current sum from the prefix sum count as we backtrack
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
    }
}

