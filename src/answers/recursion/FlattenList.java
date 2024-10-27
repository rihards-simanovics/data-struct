package answers.recursion;

import java.util.*;

public class FlattenList {

    public static List<Integer> flattenList(List<Object> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (Object elem : nestedList) {
            if (elem instanceof List) {
                result.addAll(flattenList((List<Object>) elem)); // Recur for sublist
            } else {
                result.add((Integer) elem); // Add integer directly
            }
        }
        return result;
    }
}
