package ca.judacribz.week4day1_test;

import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Algorithms {

    /*
     * 1. Create a program which checks if the string has the correct order of
     * parenthesis/brackets.
     *
     * Examples:
     * ---------
     * ({})[] = true
     * []{]}[ = false
     */
    private static final Map<Character, Character> BRACK_MAP = new HashMap<Character, Character>() {
        {
            put('{', '}');
            put('(', ')');
            put('[', ']');
        }
    };
    public static boolean checkBrackets(String str) {
        str = str.replaceAll(" ", "");
        Stack<Character> charStack = new Stack<>();
        boolean res = true;
        char b;
        for (int i = 0; i < str.length(); i++) {
            b = str.charAt(i);

            if (BRACK_MAP.containsKey(b)) {
                charStack.push(b);
            } else {
                char ch = charStack.pop();
                if (BRACK_MAP.get(ch) != b) {
                    return false;
                }
            }
        }

        return charStack.size() == 0;
    }

    /*
     * 2. Given a string and a non-empty substring sub, compute recursively if at least n copies of
     * sub appear in the string somewhere, possibly with overlapping. N will be non-negative.
     *
     * Examples:
     * ---------
     * strCopies("catcowcat", "cat", 2) → true
     * strCopies("catcowcat", "cow", 2) → false
     * strCopies("catcowcat", "cow", 1) → true
     */

    private static String string;
    private static String substring;
    private static int count;
    public static boolean strCopies(String str, String sub, int expectedCount) {
        string = str;
        substring = sub;
        count = 0;

        for (int i = 0; i <str.length(); i++) {
            if (string.charAt(i) == sub.charAt(0)) {
                if (strCopies(i, 0)) {
                    count++;
                    if (count >= expectedCount) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean strCopies(int strInd, int subInd) {
        if (strInd >= string.length()) {
            return false;
        } else if (string.charAt(strInd) != substring.charAt(subInd)) {
            return false;
        }else if (subInd == substring.length() - 1) {
            return true;
        }

        return strCopies(strInd + 1, subInd + 1);
    }
}
