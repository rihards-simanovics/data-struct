package answers.structures;

public class Stack {

    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialise stack
    public Stack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    /**
     * Push operation
     *
     * Time Complexity:
     *
     * - Best Case: Average Case: Worst Case: O(1).
     *
     * Space Complexity:
     *
     * - O(n).
     *
     * @param element
     */
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack is full.");
            return;
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
     * Space Complexity:
     *
     * - O(n).
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
     * Peek operation (view the top element)
     *
     * Time Complexity:
     *
     * - Best Case: Average Case: Worst Case: O(1).
     *
     * Space Complexity:
     *
     * - O(n).
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
