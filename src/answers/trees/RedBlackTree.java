package answers.trees;

public class RedBlackTree {

    private Node root;
    private Node TNULL;
    // Node structure

    class Node {

        int data;
        boolean color; // true for red, false for black
        Node left, right, parent;

        Node(int data) {
            this.data = data;
            this.left = this.right = this.parent = TNULL;
            this.color = true; // new node is red
        }
    }
    // Preorder

    private void preOrderHelper(Node node) {
        if (node != TNULL) {
            System.out.print(node.data + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }
    // Balance the tree after deletion

    private void fixDelete(Node x) {
        Node s;
        while (x != root && x.color == false) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.color == true) {
                    s.color = false;
                    x.parent.color = true;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }
                if (s.left.color == false && s.right.color == false) {
                    s.color = true;
                    x = x.parent;
                } else {
                    if (s.right.color == false) {
                        s.left.color = false;
                        s.color = true;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    s.color = x.parent.color;
                    x.parent.color = false;
                    s.right.color = false;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.color == true) {
                    s.color = false;
                    x.parent.color = true;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }
                if (s.right.color == false && s.left.color == false) {
                    s.color = true;
                    x = x.parent;
                } else {
                    if (s.left.color == false) {
                        s.right.color = false;
                        s.color = true;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    s.color = x.parent.color;
                    x.parent.color = false;
                    s.left.color = false;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = false;
    }
    // Balance the tree after insertion

    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == true) {
            if (k.parent == k.parent.parent.left) {
                u = k.parent.parent.right;
                if (u.color == true) {
                    k.parent.color = false;
                    u.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    rightRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.left;
                if (u.color == true) {
                    k.parent.color = false;
                    u.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    leftRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = false;
    }
    // Preorder traversal

    public void preOrder() {
        preOrderHelper(this.root);
    }
    // Search the tree

    public Node search(int k) {
        return searchTreeHelper(this.root, k);
    }

    private Node searchTreeHelper(Node node, int key) {
        if (node == TNULL || key == node.data) {
            return node;
        }
        if (key < node.data) {
            return searchTreeHelper(node.left, key);
        }
        return searchTreeHelper(node.right, key);
    }
    // Balance the tree left rotation

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }
    // Balance the tree right rotation

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }
    // Insert a node

    public void insert(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = true; // new node must be red
        Node y = null;
        Node x = this.root;
        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }
        if (node.parent == null) {
            node.color = false; // root is always black
            return;
        }
        if (node.parent.parent == null) {
            return;
        }
        fixInsert(node);
    }
    // Delete a node

    public void delete(int data) {
        deleteNode(this.root, data);
    }

    private void deleteNode(Node node, int data) {
        Node z = TNULL;
        Node x, y;
        while (node != TNULL) {
            if (node.data == data) {
                z = node;
            }
            if (node.data <= data) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        if (z == TNULL) {
            System.out.println("Couldn't find key in the tree");
            return;
        }
        y = z;
        boolean yOriginalColor = y.color;
        if (z.left == TNULL) {
            x = z.right;
            rbTransplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            rbTransplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                rbTransplant(y, y.right);
                y.right = z.right;

                y.right.parent = y;
            }
            rbTransplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == false) {
            fixDelete(x);
        }
    }
    // Transplant nodes

    private void rbTransplant(Node u, Node v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }
    // Find the minimum node

    private Node minimum(Node node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }
    // Constructor

    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = false;
        root = TNULL;
    }
}
