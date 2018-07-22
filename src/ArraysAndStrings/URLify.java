package ArraysAndStrings;

import org.junit.jupiter.api.Assertions;

public class URLify {

    public static void urlify(char[] str, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') spaceCount++;
        }
        int totalSize = length + 2 * spaceCount;
        for (int i = length-1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[--totalSize] = '0';
                str[--totalSize] = '2';
                str[--totalSize] = '%';
            } else {
                str[--totalSize] = str[i];
            }
        }
    }

    public static void main(String[] args) {
        char[] test = "Mr John Smith    ".toCharArray();
        urlify(test, 13);
        Assertions.assertEquals("Mr%20John%20Smith", String.valueOf(test));
    }
}
