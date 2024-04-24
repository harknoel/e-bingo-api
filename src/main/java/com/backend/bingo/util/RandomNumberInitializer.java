package com.backend.bingo.util;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberInitializer {
    public static List<Integer> generateRandomNumbers(int start, int end, int count) {
        if (count > end - start + 1) {
            throw new IllegalArgumentException("Count should be less than or equal to the range.");
        }

        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.ints(start, end + 1)
                .limit(count)
                .boxed()
                .collect(Collectors.toList());
    }
}
