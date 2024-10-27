package answers.sort;

/**
 * Scenario | Time Complexity | Space Complexity
 *
 * Best Case | O(n²) | O(1)
 *
 * Average Case | O(n²) | O(1)
 *
 * Worst Case | O(n²) | O(1)
 */
public class Selection {

    public static void ascending(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Assume the minimum is the first element of the unsorted part
            int minIndex = i;
            // Find the index of the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

    }

    public static void descending(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Assume the maximum is the first element of the unsorted part
            int maxIndex = i;
            // Find the index of the maximum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j; // Update maxIndex if a larger element is found
                }
            }
            // Swap the found maximum element with the first element of the unsorted part
            if (maxIndex != i) {
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }

    }

}
