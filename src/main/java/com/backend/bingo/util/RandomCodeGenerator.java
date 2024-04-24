package com.backend.bingo.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomCodeGenerator {

    private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String randomCode(int length) {
        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length); // Length of the game code

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALPHANUMERIC_CHARACTERS.length());
            char randomChar = ALPHANUMERIC_CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
