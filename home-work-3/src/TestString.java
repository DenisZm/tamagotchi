/**
 * Created by Denis on 17.11.2016.
 */
public class TestString implements Test {

    @Override
    public void createString(String sample, int count ) {
        String resultString = new String();
        for (int i = 0; i < count; i++) {
            resultString.concat(sample);
        }
        // return resultString;
    }
}
