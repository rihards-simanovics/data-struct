package answers.structures;

/**
 * Enqueue operation: O(1) (constant time, as we are adding an element at the
 * rear).
 *
 * Dequeue operation: O(1) (constant time, as we are removing an element from
 * the front).
 *
 * Peek operation: O(1) (constant time, accessing the front element).
 *
 * Space complexity: O(n), where n is the capacity of the queue.
 */
public class CircularQueue {

    private int[] queue;
    private int front, rear, size, capacity;
    // Constructor to initialise the circular queue

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    // Enqueue operation

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = data;
        size++;
    }
    // Dequeue operation

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        return data;
    }
    // Check if the queue is full

    public boolean isFull() {
        return size == capacity;
    }
    // Check if the queue is empty

    public boolean isEmpty() {
        return size == 0;
    }
    // Peek operation to return the front element

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;

        }
        return queue[front];
    }
    // Display the elements of the queue

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

}
