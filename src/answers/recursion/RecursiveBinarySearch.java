package answers.recursion;

public class RecursiveBinarySearch {

    public static int binarySearch(int[] arr, int left, int right, int target) {
        // Base Case
        if (right >= left) {
            int mid = left + (right - left) / 2;
            // Check if target is at mid
            if (arr[mid] == target) {
                return mid;
            }
            // Recur for left or right half
            if (arr[mid] > target) {
                return binarySearch(arr, left, mid - 1, target);
            }
            return binarySearch(arr, mid + 1, right, target);
        }
        return -1; // Element not present
    }

}
