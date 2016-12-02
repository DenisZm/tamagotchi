package tamagotchi.exception;

/**
 * TamagotchiException
 * Created by Denis on 13.11.2016.
 */
public class TamagotchiException extends Exception {
    private String detail;

    public TamagotchiException(String s) {
        detail = s;
    }

    public String toString() {
        return detail;
    }
}
