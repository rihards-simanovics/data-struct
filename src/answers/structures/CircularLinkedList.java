package answers.structures;

public class CircularLinkedList {

    private Node tail; // The last node in the circular linked list
    private int size; // Keeps track of the number of elements in the list

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
    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    /**
     * Method to insert a new element at the end of the linked list
     *
     * Time Complexity:
     *
     * - Best Case: Average Case: Worst Case: O(1) (constant time) since we
     * always have a reference to the tail and can insert at the end.
     *
     * Space Complexity: O(1) for each insert, but total space is O(n) for n
     * nodes.
     *
     * @param element
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            // Inserting into an empty list: new node points to itself
            tail = newNode;
            tail.next = tail;
        } else {
            // Insert at the end: new node points to the head, tail points to new node
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    /**
     * Method to delete an element from the linked list
     *
     * Time Complexity:
     *
     * - Best Case: O(1) when deleting the head node.
     *
     * - Average Case: Worst Case: O(n), where n is the number of nodes in the
     * list, if the node to be deleted is at the end or doesn’t exist.
     *
     * Space Complexity: O(1).
     *
     * @param element
     */
    public boolean delete(int data) {
        if (tail == null) {
            System.out.println("List is empty.");
            return false;
        }
        Node current = tail.next;
        Node previous = tail;
        // Traverse the list to find the node to delete
        do {
            if (current.data == data) {
                // Handle if the node to delete is the only node in the list
                if (current == tail && current.next == tail) {
                    tail = null; // List becomes empty
                } else {
                    previous.next = current.next; // Bypass the current node
                    if (current == tail) {
                        tail = previous; // Update the tail if we're deleting the last node
                    }
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        } while (current != tail.next);
        System.out.println("Element not found.");
        return false;
    }

    /**
     * Method to search for an element in the linked list
     *
     * Time Complexity:
     *
     * - Best Case: O(1) if the element is found at the head.
     *
     * - Average Case: Worst Case: O(n), where n is the number of nodes in the
     * list.
     *
     * Space Complexity: O(1).
     *
     * @param element
     */
    public int search(int data) {
        if (tail == null) {
            System.out.println("List is empty.");
            return -1;
        }
        Node current = tail.next;
        int index = 0;
        do {
            if (current.data == data) {
                return index; // Element found
            }
            current = current.next;
            index++;
        } while (current != tail.next);
        return -1; // Element not found

    }

    /**
     * Method to display the elements of the linked list
     *
     * Time Complexity:
     *
     * - Best Case: Average Case: Worst Case: O(n), where n is the number of
     * nodes (since all nodes need to be visited).
     *
     * Space Complexity: O(1).
     *
     * @param element
     */
    public void display() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = tail.next; // Start from the head (tail.next)
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next); // Stop when we come back to the head
        System.out.println();
    }

    // Method to get the size of the circular linked list
    public int getSize() {
        return size;
    }

    // Edge case handling: Deleting last node (Additional Challenge)
    public boolean removeLast() {
        if (tail == null) {
            System.out.println("List is empty.");
            return false;
        }
        Node current = tail.next;
        Node previous = tail;
        // If there is only one node
        if (current == tail) {
            tail = null;
            size--;
            return true;
        }
        // Traverse to the last node
        while (current != tail) {
            previous = current;
            current = current.next;
        }
        previous.next = tail.next; // Update previous node to point to head
        tail = previous; // Update the tail
        size--;
        return true;
    }

    /**
     * Reverse the circular linked list
     *
     * Time Complexity: O(n) to traverse the list and reverse the next pointers.
     *
     * Space Complexity: O(1) (no additional space used).
     *
     * @param element
     */
    public void reverse() {
        if (tail == null || tail.next == tail) {
            return; // Empty list or single element list, no need to reverse
        }

        Node prev = null;
        Node current = tail.next;
        Node next;
        Node head = tail.next;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        head.next = prev;
        tail = head;
    }

}
