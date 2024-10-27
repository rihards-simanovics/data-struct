package answers.recursion;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        // Base Case
        if (str.length() <= 1) {
            return true;
        }
        // Recursive Case
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }
}
