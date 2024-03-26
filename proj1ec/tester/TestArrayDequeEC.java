package tester;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;
import student.StudentArrayDeque;

import java.util.ArrayList;

public class TestArrayDequeEC {

    @Test
    public void randomizedTest() {
        StudentArrayDeque<Integer> underTest = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        StringBuilder sb = new StringBuilder();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(6);

            switch (r) {
                case 0: {
                    // addFirst
                    Integer randomVal = StdRandom.uniform(100);
                    sb.append("addFirst(").append(randomVal).append(")\n");
                    underTest.addFirst(randomVal);
                    solution.addFirst(randomVal);
                    assertEquals(
                            sb.toString(),
                            underTest.get(0),
                            solution.get(0)
                    );
                    break;
                }
                case 1: {
                    // addLast
                    Integer randomVal = StdRandom.uniform(100);
                    sb.append("addLast(").append(randomVal).append(")\n");
                    underTest.addLast(randomVal);
                    solution.addLast(randomVal);
                    assertEquals(
                            sb.toString(),
                            underTest.get(underTest.size() - 1),
                            solution.get(solution.size() - 1)
                    );
                    break;
                }
                case 2: {
                    // removeFirst
                    if (underTest.isEmpty()) {
                        continue;
                    }
                    Integer a = underTest.removeFirst();
                    Integer b = solution.removeFirst();
                    sb.append("removeFirst(): ").append(a).append("\n");
                    assertEquals(
                            sb.toString(),
                            a,
                            b
                    );
                    break;
                }
                case 3: {
                    // removeLast
                    if (underTest.isEmpty()) {
                        continue;
                    }
                    Integer a = underTest.removeLast();
                    Integer b = solution.removeLast();
                    sb.append("removeLast(): ").append(a).append("\n");
                    assertEquals(
                            sb.toString(),
                            a,
                            b
                    );
                    break;
                }
                case 4: {
                    // isEmpty
                    boolean a = underTest.isEmpty();
                    boolean b = solution.isEmpty();
                    sb.append("isEmpty(): ").append(a).append("\n");
                    assertEquals(
                            sb.toString(),
                            a,
                            b
                    );
                    break;
                }
                case 5: {
                    // size
                    int a = underTest.size();
                    int b = solution.size();
                    sb.append("size(): ").append(a).append("\n");
                    assertEquals(
                            sb.toString(),
                            a,
                            b
                    );
                    break;
                }
                case 6: {
                    // get
                    int randomIndex = StdRandom.uniform(0, underTest.size());
                    Integer a = underTest.get(randomIndex);
                    Integer b = solution.get(randomIndex);
                    sb.append("get(").append(randomIndex).append(": ").append(a).append("\n");
                    assertEquals(
                            sb.toString(),
                            a,
                            b
                    );
                    break;
                }
            }
        }
    }
}
