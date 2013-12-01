package tc.oc.commons.core.util;

import java.util.*;

/** List-related utilities. */
public class ListUtils {
    /**
     * Creates a union from all of the specified {@link List}s.
     *
     * @param lists The {@link List}s.
     * @param <T>   The type of {@link List}s.
     * @return The union.
     */
    @SafeVarargs
    public static <T> List<T> union(List<T>... lists) {
        List<T> newList = new LinkedList<>();

        for (List<T> list : lists) {
            newList.addAll(list);
        }

        return newList;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for(Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
