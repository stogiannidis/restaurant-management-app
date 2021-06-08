package softeng.aueb.restaurant.util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class RegexUtilTest {
    @Test
    public void check_for_valid_email() {
        String email = "test@aueb.gr";
        Assert.assertTrue(RegexUtil.isEmail(email));
    }
}