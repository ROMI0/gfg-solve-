-> JAVA CODE --


class Solution
{
    // Function to find the common nodes in both BSTs.
    public static ArrayList<Integer> findCommon(Node root1, Node root2)
    {
        ArrayList<Integer> commonNodes = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Perform in-order traversal of the first BST and store it in list1.
        inOrderTraversal(root1, list1);

        // Perform in-order traversal of the second BST and store it in list2.
        inOrderTraversal(root2, list2);

        // Initialize two pointers for list1 and list2.
        int pointer1 = 0;
        int pointer2 = 0;

        // Compare elements in both lists and add common elements to commonNodes.
        while (pointer1 < list1.size() && pointer2 < list2.size())
        {
            int val1 = list1.get(pointer1);
            int val2 = list2.get(pointer2);

            if (val1 == val2)
            {
                commonNodes.add(val1);
                pointer1++;
                pointer2++;
            }
            else if (val1 < val2)
            {
                pointer1++;
            }
            else
            {
                pointer2++;
            }
        }

        return commonNodes;
    }

    // Helper function for in-order traversal.
    private static void inOrderTraversal(Node root, ArrayList<Integer> list)
    {
        if (root == null)
            return;

        inOrderTraversal(root.left, list);
        list.add(root.data);
        inOrderTraversal(root.right, list);
    }
}
