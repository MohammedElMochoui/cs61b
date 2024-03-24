package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MaxArrayDequeTest {
    @Test
    public void biggestInteger() {
        class IntegerComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }

        IntegerComparator integerComparator = new IntegerComparator();
        MaxArrayDeque<Integer> l = new MaxArrayDeque<>(integerComparator);

        for (int i = 0; i < 3; i++) {
            l.addFirst(i);
        }
        l.addLast(51);

        int result = l.max();
        assertEquals(result, 51);
    }

    @Test
    public void customComparator() {
        class IntegerComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }

        IntegerComparator integerComparator = new IntegerComparator();

        // Should also work if default comparator is null
        MaxArrayDeque<Integer> l = new MaxArrayDeque<>(null);

        for (int i = 0; i < 3; i++) {
            l.addFirst(i);
        }
        l.addLast(51);

        // Should now give us the smallest integer, see above
        int result = l.max(integerComparator);
        assertEquals(result, 0);
    }

    @Test
    public void emptyDeque() {
        class IntegerComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }

        IntegerComparator integerComparator = new IntegerComparator();
        MaxArrayDeque<Integer> l = new MaxArrayDeque<>(integerComparator);

        assertNull(l.max(null));
    }

    @Test
    public void sameElements() {
        class IntegerComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }

        IntegerComparator integerComparator = new IntegerComparator();
        MaxArrayDeque<Integer> l = new MaxArrayDeque<>(integerComparator);

        for (int i = 0; i < 10; i++) {
            l.addLast(1);
        }

        assertEquals((int) l.max(), 1);
    }

}