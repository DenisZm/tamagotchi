package ex1;

import java.util.TreeSet;

/**
 * Created by denis on 01.12.16.
 */
public class TestSetOperations {
    public static void main(String[] args) {
        TreeSet<Character> set1 = new TreeSet<Character>();
        TreeSet<Character> set2 = new TreeSet<Character>();

        set1.add('A');
        set1.add('B');
        set1.add('C');
        set1.add('D');
        set1.add('E');

        set2.add('C');
        set2.add('D');
        set2.add('E');
        set2.add('F');
        set2.add('G');

        System.out.printf("SET1: %s%nSET2: %s%n", set1, set2);

        SetsOperations operations = new SetsOperations();

        System.out.printf("equals: %s%n", operations.equals(set1, set2));
        System.out.printf("union: %s%n", operations.union(set1, set2));
        System.out.printf("subtract: %s%n", operations.subtract(set1, set2));
        System.out.printf("intersect: %s%n", operations.intersect(set1, set2));
        System.out.printf("symmetric subtract: %s%n", operations.symmetricSubtract(set1, set2));
    }
}
