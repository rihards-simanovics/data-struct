package answers.structures;

public class DynamicStack {

    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialise stack
    public DynamicStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    /**
     * Push operation with dynamic resizing
     *
     * Time Complexity:
     *
     * - Best Case: Average Case: O(1) in most cases.
     *
     * - Worst Case: O(n) when the stack is resized, where n is the current size
     * of the stack.
     *
     * Space Complexity:
     *
     * - O(n), where n is the current size of the stack. When resized, the space
     * increases as 2n, but it's still O(n).
     *
     * @param element
     */
    public void push(int data) {
        if (isFull()) {
            resize();
        }
        stack[++top] = data;
    }

    /**
     * Pop operation
     *
     * Time Complexity:
     *
     * - Best Case: Average Case: Worst Case: O(1).
     *
     * Space Complexity: O(n), where n is the current size of the stack. When
     * resized, the space increases as 2n, but it's still O(n).
     *
     * @param element
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack[top--];
    }

    /**
     * Peek operation
     *
     * Time Complexity:
     *
     * - Best Case: Average Case: Worst Case: O(1).
     *
     * Space Complexity: O(n), where n is the current size of the stack. When
     * resized, the space increases as 2n, but it's still O(n).
     *
     * @param element
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack[top];
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Resize the stack when it becomes full
    private void resize() {
        System.out.println("Resizing stack...");
        int[] newStack = new int[capacity * 2];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity = capacity * 2;
    }

    // Display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}
