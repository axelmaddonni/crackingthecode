package ArraysAndStrings;

import org.junit.jupiter.api.Assertions;

public class Palindrome {

    // Case Sensitive indexing by AASCI code
    public static boolean palindrome(String str) {
        char[] chars = str.toCharArray();
        int[] counts = new int[256];
        int notEven = 0;

        for (char c : chars) {
            if (c == ' ') {
                continue;
            }
            counts[c]++;
            if (counts[c] % 2 == 1) {
                notEven++;
            } else {
                notEven--;
            }
        }

        return notEven <= 1;
    }

    // Case Insensitive indexing by Character.getNumericValue
    public static boolean palindrome2(String str) {
        char[] chars = str.toCharArray();
        int[] counts = new int[getCharacterValue('z') + 1];
        int notEven = 0;

        for (char c : chars) {
            if (c == ' ') {
                continue;
            }
            int index = getCharacterValue(c);
            if (index != -1) {
                counts[index]++;
                if (counts[index] % 2 == 1) {
                    notEven++;
                } else {
                    notEven--;
                }
            }
        }

        return notEven <= 1;
    }

    private static int getCharacterValue(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int value = Character.getNumericValue(c);
        if (a <= value && value <= z) {
            return value - a;
        }
        return -1;
    }

    public static void main(String[] args) {
        Assertions.assertEquals(true, palindrome2("a"));
        Assertions.assertEquals(true, palindrome2("Aa"));
        Assertions.assertEquals(true, palindrome2("aaa"));
        Assertions.assertEquals(true, palindrome2("baa"));
        Assertions.assertEquals(false, palindrome2("ba"));
        Assertions.assertEquals(true, palindrome2("baba"));
        Assertions.assertEquals(true, palindrome2("Tact Coa"));
    }
}
