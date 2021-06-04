package hyperquiz.util;

import hyperquiz.dao.UserRepository;
import hyperquiz.exceptions.InvalidGenderException;
import hyperquiz.model.Gender;
import hyperquiz.model.User;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    public static boolean validateString(String string, int min, int max) {

        return (string.trim().length() >= min && string.trim().length() <= max);
    }

    public static boolean validateNumber(int number) {
        return number>=0;
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

    public static Gender validateGender(String s) throws InvalidGenderException {

        String upper = s.toUpperCase(Locale.ROOT);
        if (upper.equals("M") || upper.equals("MALE")) {
            return Gender.MALE;
        } else if (upper.equals("F") || upper.equals("FEMALE")) {
            return Gender.FEMALE;
        } else {
            throw new InvalidGenderException("Enter a valid gender");
        }

    }

    public static boolean validateEmail(String s) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }



    public static boolean validatePassword(String s) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
    public static boolean validateStatus(User user, String s) {
        String upper = s.toUpperCase(Locale.ROOT);
        if (upper.equals("Y") || upper.equals("YES")) {
            user.setStatus(true);
            return true;
        } else if (upper.equals("N") || upper.equals("NO")) {
            user.setStatus(false);
            return true;
        }
        return false;
    }

    public static boolean validateTags(String s) {
        return s.contains("#");
    }

    public static boolean validateUser(String username, UserRepository ur){
        return ur.findByUsername(username).isEmpty();
    }

}
