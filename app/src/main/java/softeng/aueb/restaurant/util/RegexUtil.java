package softeng.aueb.restaurant.util;

/**
 * Class that handles regular expressions
 * @authors team23
 */
public class RegexUtil {
    public static final String mailRegex = "[^@]+@[^\\.]+\\..+";

    /**
     * Checks if the given String is an email
     * @param mail given email to be checked
     * @return {@code true} if it is and email {@code false} elsewhere
     */
    public static boolean isEmail(String mail) {
        return mail.matches(mailRegex);
    }
}