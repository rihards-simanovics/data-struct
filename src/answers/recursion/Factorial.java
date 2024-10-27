package answers.recursion;

/**
 *
 */
public class Factorial {

    public static int factorial(int n) {
        // Base Case
        if (n == 0) {
            return 1;
        }
        // Recursive Case
        return n * factorial(n - 1);
    }

}
