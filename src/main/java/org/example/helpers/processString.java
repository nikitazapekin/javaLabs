package org.example.helpers;

public class processString {
    private static final String ENGLISH_VOWELS = "aeiouAEIOU";

    public static String appendVowelsCount(String input) {
        StringBuilder sb = new StringBuilder(input);
        StringBuilder vowelsInfo = buildVowelsInfo(input);

        if (vowelsInfo.length() > 0) {
            sb.append(" (").append(vowelsInfo).append(")");
        }

        return sb.toString();
    }

    private static StringBuilder buildVowelsInfo(String input) {
        StringBuilder vowelsInfo = new StringBuilder();

        for (int i = 0; i < ENGLISH_VOWELS.length(); i++) {
            char vowel = ENGLISH_VOWELS.charAt(i);
            long count = countVowelOccurrences(input, vowel);

            if (count > 0) {
                appendVowelInfo(vowelsInfo, vowel, count);
            }
        }

        return vowelsInfo;
    }

    private static long countVowelOccurrences(String input, char vowel) {
        return input.chars()
                .filter(c -> Character.toLowerCase(c) == Character.toLowerCase(vowel))
                .count();
    }

    private static void appendVowelInfo(StringBuilder builder, char vowel, long count) {
        if (builder.length() > 0) {
            builder.append(", ");
        }
        builder.append(Character.toLowerCase(vowel))
                .append(":")
                .append(count);
    }
}