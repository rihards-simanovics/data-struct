package answers.structures;

/**
 * Enqueue (Front or Rear): O(1) on average, but O(n) when resizing occurs.
 *
 * Dequeue (Front or Rear): O(1) since it only involves updating indices. Peek
 * (Front or Rear): O(1) as it retrieves the element directly.
 *
 * Space Complexity: O(n) for storing elements in the deque.
 */
public class Deque {

    private int[] arr; // Array to store deque elements
    private int front; // Front index
    private int rear; // Rear index
    private int size; // Current number of elements
    private int capacity; // Maximum capacity of the deque

    public Deque(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = -1;
        this.rear = 0;
        this.size = 0;
    }
    // Enqueue an element at the front

    public void enqueueFront(int item) {
        if (size == capacity) {
            resize();
        }
        front = (front + 1) % capacity; // Circular increment
        arr[front] = item;
        if (size == 0) { // If it's the first element
            rear = front; // Set rear to front
        }
        size++;
    }
    // Enqueue an element at the rear

    public void enqueueRear(int item) {
        if (size == capacity) {
            resize();
        }
        rear = (rear - 1 + capacity) % capacity; // Circular decrement
        arr[rear] = item;
        if (size == 0) { // If it's the first element
            front = rear; // Set front to rear
        }
        size++;
    }
    // Dequeue an element from the front

    public int dequeueFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty. Cannot dequeue from front.");
        }
        int item = arr[front];
        front = (front - 1 + capacity) % capacity; // Circular decrement
        size--;
        return item;
    }
    // Dequeue an element from the rear

    public int dequeueRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty. Cannot dequeue from rear.");
        }
        int item = arr[rear];
        rear = (rear + 1) % capacity; // Circular increment
        size--;
        return item;
    }
    // Peek at the front element

    public int peekFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty. Cannot peek.");
        }
        return arr[front];
    }

    // Peek at the rear element
    public int peekRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty. Cannot peek.");
        }
        return arr[rear];
    }
    // Check if the deque is empty

    public boolean isEmpty() {
        return size == 0;
    }
    // Check if the deque is full

    public boolean isFull() {
        return size == capacity;
    }
    // Resize the deque when it's full

    private void resize() {
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(rear + i) % capacity]; // Copy elements in the correct order
        }
        arr = newArr;
        front = size - 1; // Set front to the last added element
        rear = 0; // Set rear to the first position
        capacity = newCapacity; // Update capacity
    }

}
