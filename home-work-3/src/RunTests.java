/**
 * Created by Denis on 17.11.2016.
 */
public class RunTests {

    public static void main(String[] args) {
        System.out.println("Test String");
        Test test1 = new TestString();
        System.out.println("Run Time: " + calculateRunTime(test1));
        System.out.println();

        System.out.println("Test StringBuilder");
        Test test2 = new TestStringBuilder();
        System.out.println("Run Time: " + calculateRunTime(test2));
        System.out.println();

        System.out.println("Test StringBuffer");
        Test test3 = new TestStringBuffer();
        System.out.println("Run Time: " + calculateRunTime(test3));
        System.out.println();
    }


    static long calculateRunTime (Test t) {
        long startTime;
        long endTime;

        startTime = System.nanoTime();
        t.printString();
        endTime = System.nanoTime();

        return endTime - startTime;
    }
}
