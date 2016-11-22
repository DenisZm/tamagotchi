/**
 * Created by Denis on 17.11.2016.
 */
public class TestStringBuilder implements Test {

    @Override
    public void createString(String sample, int count ) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            resultString.append(sample);
        }
        // return String.valueOf(resultString);
    }
}
