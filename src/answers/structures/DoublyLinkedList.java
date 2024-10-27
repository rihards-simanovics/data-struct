package answers.structures;

public class DoublyLinkedList {

    // Head of the linked list
    private Node head;

    // Define the Node class
    class Node {

        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    // Constructor to initialize an empty list
    public DoublyLinkedList() {
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
            head = newNode; // If list is empty, set new node as head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current; // Set the previous pointer of the new node
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
        Node current = head;
        // If the node to be deleted is the head node
        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return true;
        }
        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null) {
            return false; // Element not found
        }
        if (current.next != null) {
            current.next.prev = current.prev; // Update the next node's previous pointer
        }
        if (current.prev != null) {
            current.prev.next = current.next; // Update the previous node's next pointer
        }
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

    // Method to display the elements of the list
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
