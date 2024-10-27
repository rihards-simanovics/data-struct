package answers.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Scenario | Time Complexity | Space Complexity
 *
 * Best Case | O(1) | O(1)
 *
 * Average Case | O(√n) | O(1)
 *
 * Worst Case | O(√n) | O(1)
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
public class Binary {

    // Method to validate if the array is sorted
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false; // The array is not sorted
            }
        }
        return true; // The array is sorted
    }

    public static int findOne(int[] array, int target) {
        int n = array.length;
        int jump = (int) Math.sqrt(n); // Calculate the optimal jump size
        int prev = 0;
        // Jump forward in the array until the block containing the target is found
        while (array[Math.min(jump, n) - 1] < target) {
            prev = jump; // Update the previous jump
            jump += (int) Math.sqrt(n); // Move to the next block
            if (prev >= n) {
                return -1; // Target is not present
            }
        }
        // Perform a linear search in the identified block
        for (int i = prev; i < Math.min(jump, n); i++) {
            if (array[i] == target) {
                return i; // Return the index if target is found
            }
        }
        return -1; // Target is not found
    }

    /**
     * Method to perform binary search and return all indices of the target
     * value
     *
     */
    public static List<Integer> findAll(int[] array, int target) {
        List<Integer> indices = new ArrayList<>();
        int n = array.length;

        // Input validation: Check if array is null or empty
        if (array == null || n == 0) {
            throw new IllegalArgumentException("Array is empty or null.");
        }
        // Validate if the array is sorted
        if (!isSorted(array)) {
            throw new IllegalArgumentException("Array is not sorted.");
        }
        int jump = (int) Math.sqrt(n); // Calculate the optimal jump size
        int prev = 0;
        // Jump forward in the array until the block containing the target is found
        while (array[Math.min(jump, n) - 1] < target) {
            prev = jump; // Update the previous jump
            jump += (int) Math.sqrt(n); // Move to the next block
            if (prev >= n) {
                return indices; // Target is not present
            }
        }
        // Perform a linear search in the identified block to find all occurrences
        for (int i = prev; i < Math.min(jump, n); i++) {
            if (array[i] == target) {
                indices.add(i); // Store the index if target is found
            }
        }
        return indices; // Return the list of indices
    }
}
