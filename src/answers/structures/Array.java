package answers.structures;

/**
 * Scenario | Time Complexity | Space Complexity
 *
 * Best Case | O(n) | O(1)
 *
 * Average Case | O(n²) | O(1)
 *
 * Worst Case | O(n²) | O(1)
 *
 * Small Arrays (10-100 elements): Jump and Binary search perform well, faster
 * than Linear search
 *
 * Medium Arrays (1,000-10,000 elements): Binary search is the most efficient,
 * followed closely by Jump search. Linear search lags significantly.
 *
 * Large Arrays (1,000,000+ elements): Binary search maintains its efficiency,
 * Jump search performance decreases (O(√n)), and Linear search becomes very
 * slow (O(n)).
 */
public class Array {

    private int[] arr;
    private int size; // Number of elements currently in the array
    private int capacity; // Total capacity of the array

    // Constructor to initialize the array with a specific capacity
    public Array(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    /**
     * Method to insert an element into the array
     *
     * Time Complexity:
     *
     * - Best Case: O(1) when there is room in the array.
     *
     * - Average Case: O(1).
     *
     * - Worst Case: O(n) when resizing is required (as it involves copying
     * elements to a new array).
     *
     * Space Complexity:
     *
     * - O(n), where n is the number of elements.
     *
     * @param element
     */
    public void insert(int element) {
        if (size == capacity) {
            resizeArray(); // If array is full, resize it
        }
        arr[size] = element; // Add the new element
        size++; // Increase the size
    }

    /**
     * Method to delete an element from the array
     *
     * Time Complexity:
     *
     * - Best Case: O(1) if the element is at the end of the array.
     *
     * - Average Case: O(n).
     *
     * - Worst Case: O(n) when the element is at the beginning of the array
     * (requiring maximum shifting).
     *
     * Space Complexity:
     *
     * - O(1) because no extra space is required (shifting happens in place).
     *
     * @param element
     */
    public boolean delete(int element) {
        int index = search(element);
        if (index == -1) {
            return false; // Element not found
        }
        // Shift elements left to overwrite the deleted element
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--; // Reduce the size
        return true;
    }

    /**
     * Method to search for an element in the array, returns index or -1 if not
     * found
     *
     * Time Complexity:
     *
     * - Best Case: O(1) if the element is at the start of the array.
     *
     * - Average Case: O(n/2) ≈ O(n).
     *
     * - Worst Case: O(n) if the element is at the end or not found.
     *
     * Space Complexity:
     *
     * - O(1), no additional space used.
     *
     * @param element
     */
    public int search(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1; // Element not found
    }

    /**
     * Method to dynamically resize the array when it's full
     *
     * Time Complexity: O(n), where n is the number of elements being copied.
     *
     * Space Complexity:O(n), since a new array is allocated with double the
     * capacity.
     *
     * @param element
     */
    private void resizeArray() {
        capacity *= 2; // Double the capacity
        int[] newArr = new int[capacity];
        // Copy elements to the new array
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Input validation: checks for empty or invalid array
    public boolean isValidInput(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            System.out.println("Invalid input: array is empty or null.");
            return false;
        }
        return true;
    }
}
