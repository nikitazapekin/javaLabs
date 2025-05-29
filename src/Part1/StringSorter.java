package Part1;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringSorter {

    public static List<String> sortStringsAlphabetically(Collection<String> strings) {
        return strings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> words = List.of("banana", "apple", "orange", "grape", "pear");
        System.out.println("Original list: " + words);
        System.out.println("Sorted list: " + sortStringsAlphabetically(words));
    }
}