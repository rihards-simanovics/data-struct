package answers.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Scenario | Time Complexity | Space Complexity
 *
 * Best Case | O(1) | O(1)
 *
 * Average Case | O(n) | O(1)
 *
 * Worst Case | O(n) | O(1)
 */
public class Linear {

    public static int findOne(int[] array, int target) {
        // Traverse the array to find the target
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return the index if target is found
            }
        }
        return -1; // Return -1 if target is not found in the array
    }

    public static List<Integer> findAll(int[] array, int target) {
        List<Integer> indices = new ArrayList<>();
        // Input validation: Check if array is empty or null
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty or null.");
        }

        // Traverse the array to find the target and store all matching indices
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                indices.add(i);
            }
        }
        return indices; // Return the list of indices
    }
}
