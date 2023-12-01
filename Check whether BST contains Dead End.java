class Solution
{
    static boolean isDeadEnd(Node root)
    {
        return isDeadEndUtil(root, 1, Integer.MAX_VALUE);
    }

    static boolean isDeadEndUtil(Node root, int min, int max)
    {
        if (root == null) {
            return false;
        }

        // Check if the current node value is a dead end
        if (min == max) {
            return true;
        }

        // Recursively check the left and right subtrees
        boolean left = isDeadEndUtil(root.left, min, root.data - 1);
        boolean right = isDeadEndUtil(root.right, root.data + 1, max);

        // Return true if a dead end is found in any subtree
        return left || right;
    }
}
