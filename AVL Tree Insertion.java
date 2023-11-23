class Solution
{
    // Function to perform left rotation
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Function to perform right rotation
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Function to get the height of the tree
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Function to get the balance factor of a node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Function to insert a node into the AVL tree
    public Node insertToAVL(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        // Perform standard BST insertion
        if (data < root.data) {
            root.left = insertToAVL(root.left, data);
        } else if (data > root.data) {
            root.right = insertToAVL(root.right, data);
        } else {
            // Duplicate values are not allowed in AVL trees
            return root;
        }

        // Update height of current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance factor of this node
        int balance = getBalance(root);

        // Perform rotations if needed
        // Left Left Case
        if (balance > 1 && data < root.left.data) {
            return rightRotate(root);
        }
        // Right Right Case
        if (balance < -1 && data > root.right.data) {
            return leftRotate(root);
        }
        // Left Right Case
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right Left Case
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
}
 
