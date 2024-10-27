package answers.recursion;

public class GCD {

    public static int gcd(int a, int b) {
        // Base Case
        if (b == 0) {
            return a;
        }
        // Recursive Case
        return gcd(b, a % b);
    }

}
