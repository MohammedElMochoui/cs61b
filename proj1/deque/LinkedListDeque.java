package deque;

import java.util.Iterator;

public class LinkedListDeque<T> {
    private int size;
    private final ListNode<T> sentinel;
    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode<T>(null, null, null);
        sentinel.setPrevious(sentinel);
        sentinel.setNext(sentinel);
    }

    public void addFirst(T item) {
        /*
        1. new item has sentinel as previous and the next of sentinel as next
        2. sentinel gets new item as next
        3. sentinel next gets item as previous
         */
        ListNode<T> itemNode = new ListNode<>(item, sentinel, sentinel.getNext());
        sentinel.setNext(itemNode);
        itemNode.getNext().setPrevious(itemNode);
        size++;
    }

    public T removeFirst() {
        if (size == 0) return null;
        ListNode<T> first = sentinel.getNext();
        sentinel.setNext(first.getNext());
        first.getNext().setPrevious(sentinel);
        size--;
        return first.getValue();
    }

    public T removeLast() {
        if (size == 0) return null;
        ListNode<T> last = sentinel.getPrevious();
        sentinel.setPrevious(last.getPrevious());
        last.getPrevious().setNext(sentinel);
        size--;
        return last.getValue();
    }

    private ListNode<T> getListNode(int i) {
        if (i >= size) return null;
        int count = 0;
        ListNode<T> curr = sentinel.getNext();

        while (count != i) {
            count++;
            curr = curr.getNext();
        }

        return curr;
    }

    public T get(int i) {
        if (i >= size) return null;
        int count = 0;
        ListNode<T> curr = sentinel.getNext();

        while (count != i) {
            count++;
            curr = curr.getNext();
        }

        return curr.getValue();
    }

    public void addLast(T item) {
        ListNode<T> itemNode = new ListNode<>(item, sentinel.getPrevious(), sentinel);
        itemNode.getPrevious().setNext(itemNode);
        sentinel.setPrevious(itemNode);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size > 0) {
            ListNode<T> curr = sentinel;
            while (curr.getNext() != null && curr.getNext() != sentinel) {
                System.out.printf("%s ", curr.getNext());
                curr = curr.getNext();
            }
            System.out.println();
        }
    }

    public Iterator iterator() {
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other instanceof LinkedListDeque otherL) {
            if (this.size() != otherL.size) return false;
            for (int i = 0; i < size; i++) {
                if (!get(i).equals(otherL.get(i))) return false;
            }
        }
        return true;
    }

    private class ListNode<T> {
        private T value;
        private ListNode previous;
        private ListNode next;

        public ListNode(T value, ListNode previous, ListNode next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public ListNode getPrevious() {
            return previous;
        }

        public void setPrevious(ListNode previous) {
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return this.value == null ?
                    "sentinel" :
                    this.value.toString();
        }
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        ListNode<T> curr;

        public LinkedListDequeIterator() {
            this.curr = sentinel;
        }

        @Override
        public boolean hasNext() {
            return curr.getNext() != sentinel;
        }

        @Override
        public T next() {
            curr = curr.getNext();
            return curr.getValue();
        }
    }
}
