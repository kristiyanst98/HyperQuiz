package hyperquiz.util;

import hyperquiz.model.Gender;
import hyperquiz.model.User;

import java.util.Locale;

public class ValidationUtil {

    public static boolean validateString(String string, int min, int max) {
        if (string.length() >= min && string.length() <= max) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateNumber(int number, int min, int max) {
        int cnt = 1;
        int tmp = number;
        while (tmp != 0) {
            tmp /= 10;
            cnt++;
        }
        if (cnt >= min && cnt <= max) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateGender(User user,String s) {
        String upper=s.toUpperCase(Locale.ROOT);
        if (upper.equals("M")|| upper.equals("MALE")) {
            user.setGender(Gender.MALE);
            return true;
        } else if(upper.equals("F")||upper.equals("FEMALE")){
            user.setGender(Gender.FEMALE);
            return true;
        } else{
            return false;
        }
    }
}
