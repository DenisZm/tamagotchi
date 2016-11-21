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
    }
}