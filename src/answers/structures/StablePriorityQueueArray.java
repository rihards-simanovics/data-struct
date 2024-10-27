package answers.structures;

import java.util.Arrays;

/**
 * Enqueue: O(n log n) due to sorting the array after each insertion.
 *
 * Dequeue: O(1) because the first element in the sorted array is removed.
 *
 * Space Complexity: O(n) for storing the elements in the array.
 */
public class StablePriorityQueueArray {
// Inner class to represent elements with priority and insertion order

    class Element {

        int value;
        int priority;
        long insertionOrder; // Used for FIFO when priorities are the same

        public Element(int value, int priority, long insertionOrder) {
            this.value = value;
            this.priority = priority;
            this.insertionOrder = insertionOrder;
        }

        @Override
        public String toString() {

            return "Value: " + value + ", Priority: " + priority + ", InsertionOrder: "
                    + insertionOrder;
        }
    }
    private Element[] queue;
    private int size;
    private long insertionCounter;

    public StablePriorityQueueArray(int capacity) {
        queue = new Element[capacity];
        size = 0;
        insertionCounter = 0;
    }

    // Enqueue element into the queue based on its priority and insertion order
    public void enqueue(int value, int priority) {
        if (size == queue.length) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        Element newElement = new Element(value, priority, insertionCounter++);
        queue[size] = newElement;
        size++;
        // Sort the queue based on priority first, then insertion order for same priority
        Arrays.sort(queue, 0, size, (a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a.priority; // Higher priority first
            } else {
                return Long.compare(a.insertionOrder, b.insertionOrder); // FIFO for same priority
            }
        });
    }

    // Dequeue the element with the highest priority
    public Element dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        Element dequeuedElement = queue[0];
        // Shift elements left
        for (int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }
        size--;
        return dequeuedElement;

    }

    // Peek at the element with the highest priority
    public Element peek() {
        if (size == 0) {
            System.out.println("Queue is empty.");
            return null;
        }
        return queue[0];
    }
    // Check if the queue is empty

    public boolean isEmpty() {
        return size == 0;
    }
}
