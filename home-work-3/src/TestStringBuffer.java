/**
 * Created by Denis on 17.11.2016.
 */
public class TestStringBuffer implements Test {

    @Override
    public void printString() {
        StringBuffer str = new StringBuffer("Initial test string");
        str.append(" add some words");
        str.append(" and another word");
        str.append(" more more words").append(" test append");
        str.append(" springs");
        System.out.println(str);
    }
}