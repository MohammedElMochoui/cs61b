package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.c = c;
    }

    public T max() {
        return max(c);
    }

    public T max(Comparator<T> comparator) {
        if (this.isEmpty()) {
            return null;
        }
        T max = this.get(0);
        for (T item : this) {
            if (comparator.compare(item, max) > 0) {
                max = item;
            }
        }
        return max;
    }
}
