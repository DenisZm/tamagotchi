/**
 * Created by Denis on 17.11.2016.
 */
public class TestString implements Test {
    @Override

    public void printString() {
        String str1 = "Initial test string";
        str1 += " add some words";
        str1 += " and another word";
        str1 += " more more words" + " test append";
        str1 += " springs";
        System.out.println(str1);
    }
}
