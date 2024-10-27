package answers.structures;

import java.util.Arrays;

/**
 * Enqueue: O(n log n) due to sorting the array after each insertion.
 *
 * Dequeue: O(1) because we remove the highest-priority element (the first
 * element in the sorted array).
 *
 * Space Complexity: O(n) for storing the elements in the array
 */
public class PriorityQueueArray {
// Inner class to represent elements with priority

    class Element {

        int value;
        int priority;

        public Element(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Value: " + value + ", Priority: " + priority;
        }
    }
    private Element[] queue;
    private int size;

    public PriorityQueueArray(int capacity) {
        queue = new Element[capacity];
        size = 0;
    }
    // Enqueue element into the queue based on its priority

    public void enqueue(int value, int priority) {
        if (size == queue.length) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        Element newElement = new Element(value, priority);
        queue[size] = newElement;
        size++;
        // Sort the queue based on priority
        Arrays.sort(queue, 0, size, (a, b) -> b.priority - a.priority);
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
