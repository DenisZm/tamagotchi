/**
 * Created by Denis on 17.11.2016.
 */
public class SimpleStringTest {
    public static void main(String[] args) {
        long startTime;
        long runTime;

        System.out.println("Test String:");
        startTime = System.nanoTime();
        String str1 = "Initial test string";
        str1 += " add some words";
        str1 += " and another word";
        str1 += " more more words" + " test append";
        str1 += " springs";
        runTime = System.nanoTime() - startTime;
        System.out.println(str1);

        System.out.println("Run time: " + runTime);
        System.out.println();

        System.out.println("Test StringBuilder:");
        startTime = System.nanoTime();
        StringBuilder str2 = new StringBuilder("Initial test string");
        str2.append(" add some words");
        str2.append(" and another word");
        str2.append(" more more words").append(" test append");
        str2.append(" springs");
        runTime = System.nanoTime() - startTime;
        System.out.println(str2);

        System.out.println("Run time: " + runTime);
        System.out.println();

        System.out.println("Test StringBuffer:");
        startTime = System.nanoTime();
        StringBuffer str3 = new StringBuffer("Initial test string");
        str3.append(" add some words");
        str3.append(" and another word");
        str3.append(" more more words").append(" test append");
        str3.append(" springs");
        runTime = System.nanoTime() - startTime;
        System.out.println(str3);

        System.out.println("Run time: " + runTime);
        System.out.println();
    }
}