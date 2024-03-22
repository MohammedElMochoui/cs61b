package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> aList = new AListNoResizing<>();
        BuggyAList<Integer> buggyList = new BuggyAList<>();

        aList.addLast(4);
        aList.addLast(5);
        aList.addLast(6);

        buggyList.addLast(4);
        buggyList.addLast(5);
        buggyList.addLast(6);

        assertEquals(aList.removeLast(), buggyList.removeLast());
        assertEquals(aList.removeLast(), buggyList.removeLast());
        assertEquals(aList.removeLast(), buggyList.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 500000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            switch (operationNumber) {
                case 0: {
                    // addLast
                    assertEquals(L.size(), B.size());
                    int randVal = StdRandom.uniform(0, 100);
                    L.addLast(randVal);
                    System.out.println("(L) addLast(" + randVal + ")");
                    B.addLast(randVal);
                    System.out.println("(B) addLast(" + randVal + ")");
                    break;
                }
                case 1: {
                    // getLast
                    assertEquals(L.size(), B.size());
                    if (!(L.size() > 0)) continue;
                    int lInt = L.getLast();
                    System.out.printf("(L) getLast(%d)%n", lInt);
                    if ((B.size() > 0)) continue;
                    int bInt = B.getLast();
                    System.out.printf("(B) getLast(%d)%n", bInt);
                    assertEquals(lInt, bInt);
                    break;
                }
                case 2: {
                    // removeLast
                    assertEquals(L.size(), B.size());
                    if (!(L.size() > 0)) continue;
                    int lInt = L.removeLast();
                    System.out.printf("(L) removeLast(%d)%n", lInt);
                    if (!(B.size() > 0)) continue;
                    int bInt = B.removeLast();
                    System.out.printf("(B) removeLast(%d)%n", bInt);
                    assertEquals(lInt, bInt);
                    break;
                }
                case 3: {
                    // size
                    assertEquals(L.size(), B.size());
                    int sizeL = L.size();
                    System.out.println("(L) size: " + sizeL);
                    int sizeB = B.size();
                    System.out.println("(B) size: " + sizeB);
                    assertEquals(sizeL, sizeB);
                    break;
                }
            }
        }
    }
}
