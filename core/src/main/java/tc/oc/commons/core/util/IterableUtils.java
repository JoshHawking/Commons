package tc.oc.commons.core.util;

import com.google.common.base.Preconditions;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/** {@link Iterable}-related utilities. */
public class IterableUtils {
    /**
     * Finds the most common element in the specified {@link Iterable}. If there is a tie and <code>tie</code> is true,
     * a random selection (from the tied elements) is made. If there is a tie and <code>tie</code> is not true,
     * <code>null</code> is returned, instead.
     *
     * @param iterable The {@link Iterable} to check.
     * @param <T>      The type of the {@link Iterable}.
     * @return The most common element, an arbitrary selection from the tied elements if a tie arises and
     *         <code>tie</code> is true, or <code>null</code> if a tie arises and <code>tie</code> is not true..
     */
    public static @Nullable <T> T findMostCommon(Iterable<T> iterable, boolean tie) {
        HashMap<T, Integer> counts = new HashMap<>();
        for (T obj : Preconditions.checkNotNull(iterable, "Iterable")) {
            Integer count = counts.get(obj);
            counts.put(obj, count == null ? 1 : count + 1);
        }

        int max = 0;
        T maxObj = null;
        for (Map.Entry<T, Integer> entry : counts.entrySet()) {
            int value = entry.getValue();
            if (maxObj == null || value >= max) {
                max = value;
                maxObj = entry.getKey();
            }
        }

        if (!tie && maxObj != null) {
            for (Map.Entry<T, Integer> entry : counts.entrySet()) {
                if (entry.getValue() == max && !maxObj.equals(entry.getKey())) {
                    return null;
                }
            }
        }

        return maxObj;
    }

    /**
     * Finds the most common element in the specified {@link Iterable}. If there is a tie, a random selection (from the
     * tied elements) is made. If this functionality is undesired, {@link #findMostCommon(Iterable, boolean)} may be
     * used instead.
     *
     * @param iterable The {@link Iterable} to check.
     * @param <T>      The type of the {@link Iterable}.
     * @return The most common element, or an arbitrary selection from the tied elements if a tie arises.
     */
    public static <T> T findMostCommon(Iterable<T> iterable) {
        return findMostCommon(iterable, true);
    }

}
