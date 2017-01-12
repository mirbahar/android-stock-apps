package com.stock.rahat.stock.libraries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rahat on 1/12/2017.
 */

public class Validation {


    public boolean isValidEmail(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
         return matcher.matches();

    }

    public boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 6) {
            return true;
        }
        return false;
    }
    public boolean isFullName(String fullname) {
        if (fullname.matches("")) {
            return false;
        } else {
            return true;
        }

    }
    public boolean isUserName(String username) {
        if (username.matches("")) {
            return false;
        } else {
            return true;
        }

    }
}
