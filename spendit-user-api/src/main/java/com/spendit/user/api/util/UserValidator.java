package com.spendit.user.api.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class UserValidator {

    public static boolean isValidEmail(String email) {
        final Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        return pattern.matcher(email).matches();
    }

    public static boolean isValidUsername(String username) {
        final Pattern pattern = Pattern.compile("[a-zA-Z0-9]{4,10}");

        if (StringUtils.isBlank(username) || !pattern.matcher(username).matches()) {
            return false;
        }
        return true;
    }

    public static boolean isValidPassword(String password) {
        if (StringUtils.isBlank(password) || password.length() < 6) {
            return false;
        }
        return true;
    }
}
