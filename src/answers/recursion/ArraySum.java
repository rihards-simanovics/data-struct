package answers.recursion;

public class ArraySum {

    public static int sum(int[] arr, int n) {
        // Base Case
        if (n <= 0) {
            return 0;
        }
        // Recursive Case
        return arr[n - 1] + sum(arr, n - 1);
    }

}
