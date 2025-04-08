package org.example.BracketUtils;


public class BracketUtils {
    public static boolean isBracket(char c) {
        return c == '(' || c == ')' || c == '[' || c == ']' ||
                c == '{' || c == '}' || c == '<' || c == '>';
    }

    public static boolean isOpeningBracket(char c) {
        return c == '(' || c == '[' || c == '{' || c == '<';
    }

    public static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}') ||
                (opening == '<' && closing == '>');
    }
}