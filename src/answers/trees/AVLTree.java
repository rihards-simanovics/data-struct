package answers.trees;

public class AVLTree {

    class AVLNode {

        int key, height;
        AVLNode left, right;

        public AVLNode(int key) {
            this.key = key;
            this.height = 1; // New node is initially added at leaf
        }
    }
    private AVLNode root;
    // Utility function to get the height of the node

    private int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }
    // Utility function to get the balance factor of a node

    private int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }
    // Right rotation

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        // Perform rotation
        x.right = y;
        y.left = T2;
        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        // Return new root
        return x;
    }
    // Left rotation

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        // Perform rotation
        y.left = x;
        x.right = T2;
        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        // Return new root
        return y;
    }
    // Insert a node

    public void insert(int key) {
        root = insert(root, key);
    }

    private AVLNode insert(AVLNode node, int key) {
        // Normal BST insertion
        if (node == null) {
            return new AVLNode(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; // Duplicates are not allowed
        }
        // Update height of this ancestor node
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        // Get the balance factor
        int balance = getBalance(node);
        // If the node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }
        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    // Delete a node

    public void delete(int key) {
        root = delete(root, key);
    }

    private AVLNode delete(AVLNode root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = (root.left != null) ? root.left : root.right;
                // No child case
                if (temp == null) {
                    return null;
                } else { // One child case
                    return temp;
                }
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree )
            AVLNode temp = minValueNode(root.right);
            root.key = temp.key; // Copy the inorder successor's content to this node
            root.right = delete(root.right, temp.key); // Delete the inorder successor
        }
        // If the tree had only one node then return
        if (root == null) {
            return root;
        }
        // STEP 2: UPDATE HEIGHT OF THIS ANCESTOR NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    // Utility function to find the node with the minimum value greater than the node

    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    // Search a node

    public boolean search(int key) {
        return search(root, key);
    }

    private boolean search(AVLNode node, int key) {
        if (node == null) {
            return false;
        }
        if (key < node.key) {
            return search(node.left, key);
        } else if (key > node.key) {
            return search(node.right, key);
        } else {
            return true; // Node found
        }
    }
    // Print the tree (In-Order Traversal)

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

}
