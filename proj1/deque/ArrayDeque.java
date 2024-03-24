package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {
    private T[] items;
    private int size;
    private int capacity;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
        firstIndex = 0;
        lastIndex = 0;
    }

    private int decrementIndex(int i) {
        int offset = i - 1;
        if (offset < 0) {
            return capacity + offset;
        }
        return offset;
    }

    public void addFirst(T item) {
        int index = decrementIndex(firstIndex);
        items[index] = item;
        firstIndex = index;
        size++;

        if (size == 1) {
            lastIndex = index;
        }
        if (size == capacity) {
            grow();
        }
    }

    private int incrementIndex(int i) {
        int offset = i + 1;
        return offset % capacity;
    }

    public void addLast(T item) {
        int index = incrementIndex(lastIndex);
        items[index] = item;
        lastIndex = index;
        size++;

        if (size == 1) {
            firstIndex = index;
        }
        if (size == capacity) {
            grow();
        }
    }

    private void grow() {
        double percentage = ((double) size / capacity) * 100;

        int newCapacity = capacity * 2;
        T[] arr = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            arr[i] = items[(firstIndex + i) % capacity];
        }
        firstIndex = 0;
        lastIndex = size - 1;
        items = arr;
        capacity = newCapacity;
    }

    private void shrink() {
        double percentage = ((double) size / capacity) * 100;

        int newCapacity = capacity / 2;
        T[] arr = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            arr[i] = items[(firstIndex + i) % capacity];
        }
        firstIndex = 0;
        lastIndex = size - 1;
        items = arr;
        capacity = newCapacity;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", items[(firstIndex + i) % capacity].toString());
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T item = items[firstIndex];
        firstIndex = incrementIndex(firstIndex);
        size--;

        if (capacity > 16 && size < (capacity / 4)) {
            shrink();
        }
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T item = items[lastIndex];
        lastIndex = decrementIndex(lastIndex);
        size--;

        if (capacity > 16 && size < (capacity / 4)) {
            shrink();
        }
        return item;
    }

    public T get(int i) {
        if (i >= size) {
            return null;
        }
        return items[(firstIndex + i) % capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArrayDeque) {
            ArrayDeque otherArrayDeque = (ArrayDeque) obj;
            if (size != otherArrayDeque.size()) return false;
            for (int i = 0; i < size; i++) {
                if (!get(i).equals(otherArrayDeque.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return items[(firstIndex + index++) % capacity];
        }
    }
}
