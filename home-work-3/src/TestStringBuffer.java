/**
 * Created by Denis on 17.11.2016.
 */
public class TestStringBuffer implements Test {

    @Override
    public void createString(String sample, int count ) {
        StringBuffer resultString = new StringBuffer();
        for (int i = 0; i < count; i++) {
            resultString.append(sample);
        }
        // return String.valueOf(resultString);
    }
}