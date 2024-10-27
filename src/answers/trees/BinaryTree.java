package answers.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    class BinaryTreeNode {

        int data;
        BinaryTreeNode left, right;

        public BinaryTreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }
    // Insert a node in the Binary Tree

    public BinaryTreeNode insert(BinaryTreeNode root, int data) {
        if (root == null) {
            return new BinaryTreeNode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    // Find the minimum value node

    public BinaryTreeNode minValueNode(BinaryTreeNode node) {
        BinaryTreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    // Delete a node from the Binary Tree

    public BinaryTreeNode delete(BinaryTreeNode root, int data) {
        if (root == null) {
            return root;
        }
        // Traverse the tree
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;

            }// Node with two children: get the inorder successor (smallest in the right subtree)
            BinaryTreeNode temp = minValueNode(root.right);
            // Replace the data with inorder successor's data
            root.data = temp.data;
            // Delete the inorder successor
            root.right = delete(root.right, temp.data);
        }
        return root;
    }
    // In-order traversal (Left, Root, Right)

    public void inorder(BinaryTreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    // Pre-order traversal (Root, Left, Right)

    public void preorder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    // Post-order traversal (Left, Right, Root)

    public void postorder(BinaryTreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Level-order traversal (Breadth-First Traversal)
    public void levelOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
