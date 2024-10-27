package answers.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    public static List<String> permute(String str) {
        // Base Case
        if (str.isEmpty()) {
            List<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }
        // Recursive Case
        char firstChar = str.charAt(0);
        String remainingStr = str.substring(1);
        List<String> words = permute(remainingStr);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                result.add(insertCharAt(word, firstChar, i));
            }
        }
        return result;
    }

    public static String insertCharAt(String word, char ch, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + ch + end;
    }

}
