package answers.recursion;

/**
 *
 */
public class Fibonacci {

    public static int fibonacci(int n) {
        // Base Cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // Recursive Case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
