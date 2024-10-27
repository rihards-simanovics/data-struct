package answers.trees;

public class BinarySearchTreeNode {

    int data;
    BinarySearchTreeNode left;
    BinarySearchTreeNode right;

    public BinarySearchTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    // Insert a new value into the BST

    public BinarySearchTreeNode insert(int value) {
        if (value < data) {
            if (left == null) {
                left = new BinarySearchTreeNode(value);
            } else {
                left = left.insert(value);
            }
        } else if (value > data) {
            if (right == null) {
                right = new BinarySearchTreeNode(value);
            } else {
                right = right.insert(value);
            }
        }
        return this; // return the unchanged node pointer
    }
    // Search for a value in the BST

    public BinarySearchTreeNode search(int value) {
        if (value == data) {
            return this; // Value found
        } else if (value < data) {
            return (left != null) ? left.search(value) : null; // Search left
        } else {
            return (right != null) ? right.search(value) : null; // Search right
        }
    }
    // Delete a value from the BST

    public BinarySearchTreeNode delete(int value) {
        if (value < data) {
            if (left != null) {
                left = left.delete(value);
            }
        } else if (value > data) {
            if (right != null) {
                right = right.delete(value);
            }
        } else {
            // Node with only one child or no child
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;

            }// Node with two children: Get the inorder successor (smallest in the right subtree)
            BinarySearchTreeNode successor = right.findMin();
            data = successor.data; // Copy the inorder successor's value to this node
            right = right.delete(successor.data); // Delete the inorder successor
        }
        return this;
    }
    // Find the minimum value node

    public BinarySearchTreeNode findMin() {
        return (left != null) ? left.findMin() : this;
    }
    // In-order traversal

    public void inOrderTraversal() {
        if (left != null) {
            left.inOrderTraversal();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.inOrderTraversal();
        }
    }

}
