package org.example.helpers;

import org.example.helpers.sortMethods;
import java.util.Comparator;

public class sortMethods {
    public static int comparisonCount = 0;


    public static Comparator<String> bySubstringPosition(String substring) {
        return (s1, s2) -> {
            comparisonCount++;
            int pos1 = s1.indexOf(substring);
            int pos2 = s2.indexOf(substring);
            return Integer.compare(pos1, pos2);
        };
    }

    public static Comparator<String> byLowerCaseCount() {
        return (s1, s2) -> {
            comparisonCount++;
            long count1 = s1.chars().filter(Character::isLowerCase).count();
            long count2 = s2.chars().filter(Character::isLowerCase).count();
            return Long.compare(count1, count2);
        };
    }
}
