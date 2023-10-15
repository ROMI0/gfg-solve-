15/10/23
java code->
class GfG
{
    Node buildBalancedTree(Node root) 
    {
        // Step 1: Perform in-order traversal to collect nodes in sorted order
        ArrayList<Node> sortedNodes = new ArrayList<>();
        inOrderTraversal(root, sortedNodes);

        // Step 2: Build a balanced BST from the sorted nodes
        return buildBalancedBST(sortedNodes, 0, sortedNodes.size() - 1);
    }

    // Helper function for in-order traversal
    void inOrderTraversal(Node root, ArrayList<Node> sortedNodes) {
        if (root == null)
            return;

        inOrderTraversal(root.left, sortedNodes);
        sortedNodes.add(root);
        inOrderTraversal(root.right, sortedNodes);
    }

    // Helper function to build a balanced BST from sorted nodes
    Node buildBalancedBST(ArrayList<Node> sortedNodes, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node root = sortedNodes.get(mid);

        root.left = buildBalancedBST(sortedNodes, start, mid - 1);
        root.right = buildBalancedBST(sortedNodes, mid + 1, end);

        return root;
    }
}
