package hellocucumber;

/**
 * Created by tito on 01/04/19.
 */
public class IsItFriday {
    static String isItFriday(String today) {
        if (today.equals("Friday")) {
            return "TGIF";
        }
        return "Nope";
    }
}