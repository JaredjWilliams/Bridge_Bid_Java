package com.example.bridge_bid_app_java.utils;

public class CapitalizeFirstLetter {

    public static String capitalizeFirstLetter(String input) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < input.toCharArray().length; i++) {
            char c = input.charAt(i);
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            } else if (capitalizeNext) {
                if (i == 0) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(" ").append(Character.toUpperCase(c));
                }
                capitalizeNext = false;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
