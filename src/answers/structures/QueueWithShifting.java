package answers.structures;

/**
 * Enqueue operation: O(1) (constant time, adding an element at the rear).
 * Dequeue operation: O(n) (removing an element from the front and shifting).
 * Peek operation: O(1) (constant time, accessing the front element). Space
 * complexity: O(n), where n is the capacity of the queue.
 */
public class QueueWithShifting {

    private int[] queue;
    private int capacity;
    private int size;

    public QueueWithShifting(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
    }

    // Enqueue operation with resizing
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queues if full. Cannot enqueue.");
            return;
        }
        queue[size] = value;
        size++;
    }

    // Dequeue operation with shifting
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int value = queue[0]; // Get the front element
        // Shift all elements to the left by 1 position
        for (int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }
        size--; // Reduce the size of the queue
        return value;
    }

    // Peek operation
    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queue[0]; // Front element is always at index 0
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the size of the queue
    public int size() {
        return size;
    }
    // Return the capacity of the queue

    public int capacity() {
        return capacity;
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}
