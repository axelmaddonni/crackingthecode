package ArraysAndStrings;

import org.junit.jupiter.api.Assertions;

public class CountCompression {

    public static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char actual = '\0';
        for (int i = 0; i < str.length(); i++) {
            if (actual == str.charAt(i)) {
                count++;
            }
            if (actual != str.charAt(i)) {
                if (i != 0) {
                    sb.append(actual);
                    sb.append(count);
                    if (sb.length() >= str.length()) {
                        return str;
                    }
                }
                actual = str.charAt(i);
                count = 1;
            }
        }
        if (count > 0) {
            sb.append(actual);
            sb.append(count);
            if (sb.length() >= str.length()) {
                return str;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Assertions.assertEquals("a5", compress("aaaaa"));
        Assertions.assertEquals("a5b2", compress("aaaaabb"));
        Assertions.assertEquals("a5b1", compress("aaaaab"));
        Assertions.assertEquals("a", compress("a"));
        Assertions.assertEquals("", compress(""));
        Assertions.assertEquals("ab", compress("ab"));
        Assertions.assertEquals("aab", compress("aab"));
        Assertions.assertEquals("aabb", compress("aabb"));
        Assertions.assertEquals("a2b3", compress("aabbb"));
    }
}
