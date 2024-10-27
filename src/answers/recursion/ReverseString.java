package answers.recursion;

public class ReverseString {

    public static String reverse(String str) {
        // Base Case
        if (str.isEmpty()) {
            return str;
        }
        // Recursive Case: Reverse substring and concatenate the first character
        return reverse(str.substring(1)) + str.charAt(0);
    }

}
