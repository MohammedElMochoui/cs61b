package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ArrayDequeTest {
    @Test
    public void addTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();

        final int N = 500000;

        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            switch (operationNumber) {
                case 0: {
                    int randVal = StdRandom.uniform(0, 100);
                    int prevSize = l.size();

                    l.addFirst(randVal);
                    int result = l.get(0);

                    assertEquals(result, randVal);
                    assertEquals(prevSize, l.size() - 1);
                    break;
                }
                case 1: {
                    int randVal = StdRandom.uniform(0, 100);
                    int prevSize = l.size();

                    l.addLast(randVal);
                    int result = l.get(l.size() - 1);

                    assertEquals(result, randVal);
                    assertEquals(prevSize, l.size() - 1);
                    break;
                }
                case 3: {
                    int prevSize = l.size();
                    if (l.isEmpty()) {
                        assertNull(l.removeFirst());
                        continue;
                    }

                    int prevFirstValue = l.get(0);

                    if (l.size() == 1) {
                        assertEquals(prevFirstValue, (int) l.removeFirst());
                        assertEquals(l.size(), prevSize - 1);
                        continue;
                    }

                    int newFirst = l.get(1);

                    int removedValue = l.removeFirst();
                    int first = l.get(0);

                    assertEquals(first, newFirst);
                    assertEquals(prevSize, l.size() + 1);
                    assertEquals(prevFirstValue, removedValue);
                    break;
                }
                case 4: {
                    int prevSize = l.size();

                    if (l.isEmpty()) {
                        assertNull(l.removeFirst());
                        continue;
                    }

                    int prevLastValue = l.get(l.size() - 1);

                    if (l.size() == 1) {
                        assertEquals(prevLastValue, (int) l.removeFirst());
                        assertEquals(l.size(), prevSize - 1);
                        continue;
                    }

                    int newLast = l.get(l.size() - 2);

                    int removedValue = l.removeLast();
                    int last = l.get(0);

                    assertEquals(last, newLast);
                    assertEquals(prevSize, l.size() + 1);
                    assertEquals(prevLastValue, removedValue);
                    break;
                }
            }
        }
    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        for (int i = 0; i < 7; i++) {
            l.addLast(i);
        }
        for (Integer i : l) {
//            System.out.println(i);
        }
    }

    @Test
    public void addFirstAddLastTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        int N = 50;
        for (int i = 0; i < 50; i++) {
            l.addLast(i);
            l.addFirst(i);
        }

        int a = 0;
        int b = 0;

        for (int i = 0; i < N; i++) {
            a += l.get(i);
        }
        for (int i = 0; i < N; i++) {
            b += l.get(i);
        }

        assertEquals(a, b);
    }
}
