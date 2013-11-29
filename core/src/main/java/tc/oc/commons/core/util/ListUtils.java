package tc.oc.commons.core.util;

import java.util.LinkedList;
import java.util.List;

/** List-related utilities. */
public class ListUtils {
    /**
     * Creates a union from all of the specified {@link List}s.
     *
     * @param lists The {@link List}s.
     * @param <T>   The type of {@link List}s.
     * @return The union.
     */
    public static <T> List<T> union(List<T>... lists) {
        List<T> newList = new LinkedList<>();

        for (List<T> list : lists) {
            newList.addAll(list);
        }

        return newList;
    }
}
