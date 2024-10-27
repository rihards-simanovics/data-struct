package answers.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Scenario | Time Complexity | Space Complexity
 *
 * Best Case | O(1) | O(1)
 *
 * Average Case | O(log n) | O(1)
 *
 * Worst Case | O(log n) | O(1)
 *
 * Small Arrays (e.g., 10-100 elements): Binary search performs very
 * efficiently, typically completing in a few iterations
 *
 * Medium Arrays (e.g., 1,000-10,000 elements): Still performs efficiently with
 * O(log n) complexity. For example, a search in an array of 10,000 elements
 * would require at most about 14 comparisons.
 *
 * Large Arrays (e.g., 1,000,000+ elements): The performance remains
 * logarithmic; however, the time taken is noticeable. For an array with
 * 1,000,000 elements, it may take around 20 comparisons.
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
        int left = 0; // Starting index
        int right = array.length - 1; // Ending index
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index
            // Check if target is present at mid
            if (array[mid] == target) {
                return mid; // Target found at index mid
            } // If target is greater, ignore the left half
            else if (array[mid] < target) {
                left = mid + 1; // Move to the right half
            } // If target is smaller, ignore the right half
            else {
                right = mid - 1; // Move to the left half
            }
        }
        return -1; // Target not found
    }

    /**
     * Method to perform binary search and return all indices of the target
     * value
     *
     */
    public static List<Integer> findAll(int[] array, int target) {
        List<Integer> indices = new ArrayList<>();
        // Input validation: Check if array is null or empty
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty or null.");
        }

        // Validate if the array is sorted
        if (!isSorted(array)) {
            throw new IllegalArgumentException("Array is not sorted.");
        }

        // Perform binary search to find the target
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if target is present at mid
            if (array[mid] == target) {
                // Found the target, now find all occurrences
                indices.add(mid);
                // Search to the left of mid
                int leftIndex = mid - 1;
                while (leftIndex >= 0 && array[leftIndex] == target) {
                    indices.add(leftIndex);
                    leftIndex--;
                }
                // Search to the right of mid
                int rightIndex = mid + 1;
                while (rightIndex < array.length && array[rightIndex] == target) {
                    indices.add(rightIndex);
                    rightIndex++;
                }
                // Return all found indices
                return indices;
            } // If target is greater, ignore the left half
            else if (array[mid] < target) {
                left = mid + 1; // Move to the right half
            } // If target is smaller, ignore the right half
            else {
                right = mid - 1; // Move to the left half
            }
        }
        return indices; // Return an empty list if target is not found
    }
}
