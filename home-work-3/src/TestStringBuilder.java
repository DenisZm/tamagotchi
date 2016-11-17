/**
 * Created by Denis on 17.11.2016.
 */
public class TestStringBuilder implements Test {

    @Override
    public void printString() {
        StringBuilder str = new StringBuilder("Initial test string");
        str.append(" add some words");
        str.append(" and another word");
        str.append(" more more words").append(" test append");
        str.append(" springs");
        System.out.println(str);
    }
}
