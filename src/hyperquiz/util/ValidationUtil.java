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

    public static boolean validateNumber(int number){
        if(number>=0){
            return true;
        }else{
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

    public static Gender validateGender(String s) {
        String upper=s.toUpperCase(Locale.ROOT);
        if (upper.equals("M")|| upper.equals("MALE")) {
            return Gender.MALE;
        } else if(upper.equals("F")||upper.equals("FEMALE")){
            return Gender.FEMALE;
        } else{
            return null;
        }
    }
    public static boolean validateEmail(String s){
        if(s.contains("@") && s.contains(".")){
            return true;
        }else{
            return false;
        }
    }
    public static boolean validateStatus(User user,String s){
        String upper = s.toUpperCase(Locale.ROOT);
        if(upper.equals("Y")||upper.equals("YES")){
            user.setStatus(true);
            return true;
        }else if(upper.equals("N")||upper.equals("NO")){
            user.setStatus(false);
            return true;
        }
        return false;
    }
    public static boolean validateTags(String s){
        if(s.contains("#")){
            return true;
        }else{
            return false;
        }
    }
}
