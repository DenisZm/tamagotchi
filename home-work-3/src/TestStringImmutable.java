/**
 * Created by Denis on 21.11.2016.
 */
public class TestStringImmutable {
    public static void main(String[] args) {
        String s1 = "string 1";
        String s2 = s1;
        s1 += " add word";

        System.out.printf("s1 : %s\n", s1);
        System.out.printf("s2 : %s\n", s2);

        StringBuilder s3 = new StringBuilder("string 3");
        StringBuilder s4 = s3;
        s3.append(" add word");

        System.out.printf("s3 : %s\n", s3);
        System.out.printf("s4 : %s\n", s4);
    }
}