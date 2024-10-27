package answers.sort;

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
public class Bubble {

    public static void ascending(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Last i elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void descending(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Last i elements are already sorted
            for (int j = 0; j < n - 1 - i; j++) {
                // Change the comparison to sort in descending order
                if (array[j] < array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

}
