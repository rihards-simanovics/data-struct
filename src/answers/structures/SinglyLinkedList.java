package answers.structures;

public class SinglyLinkedList {

    // Head of the linked list
    private Node head;

    // Define the Node class
    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize an empty list
    public SinglyLinkedList() {
        head = null;
    }

    /**
     * Method to insert a new element at the end of the linked list
     *
     * Time Complexity:
     *
     * - Best Case: O(1) when inserting the first element.
     *
     * - Average Case: Worst Case: O(n), where n is the number of nodes in the
     * list, as we need to traverse to the end to insert the new element.
     *
     * Space Complexity: O(1) (in terms of extra space, only a single node is
     * created).
     *
     * @param element
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Link the new node at the end of the list
        }
    }

    /**
     * Method to delete an element from the linked list
     *
     * Time Complexity:
     *
     * - Best Case: O(1) if the element to delete is at the head.
     *
     * - Average Case: Worst Case: O(n), where n is the number of nodes in the
     * list (if the element to delete is at the end or doesn't exist).
     *
     * Space Complexity: O(1).
     *
     * @param element
     */
    public boolean delete(int data) {
        if (head == null) {
            return false; // List is empty
        }
        if (head.data == data) {
            head = head.next; // Delete the head node
            return true;
        }
        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false; // Element not found
        }
        previous.next = current.next; // Bypass the node to be deleted
        return true;
    }

    /**
     * Method to search for an element in the linked list
     *
     * Time Complexity:
     *
     * - Best Case: O(1) if the element is at the head.
     *
     * - Average Case: O(n), where n is the number of nodes in the list (if the
     * element is at the end or doesn't exist).
     *
     * Space Complexity: O(1).
     *
     * @param element
     */
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true; // Element found
            }
            current = current.next;
        }
        return false; // Element not found
    }

    // Method to display the elements of the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
