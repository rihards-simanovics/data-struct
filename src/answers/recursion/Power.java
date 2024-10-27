package answers.recursion;

/**
 *
 */
public class Power {

    public static int power(int x, int n) {
        // Base Case
        if (n == 0) {
            return 1;
        }
        // Recursive Case
        return x * power(x, n - 1);
    }

}
