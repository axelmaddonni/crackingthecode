package ArraysAndStrings;

import org.junit.jupiter.api.Assertions;

public class OneEditAway {

    public static boolean oneEditWay(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (Math.abs(lenA - lenB) > 1) return false;

        if (lenA == lenB) {
            return oneReplaceAway(a,b);
        } else if (lenB > lenA) {
            return oneInsertAway(a, b);
        } else {
            return oneInsertAway(b, a);
        }
    }

    private static boolean oneReplaceAway(String a, String b) {
        boolean foundDifference = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }
        return true;
    }

    private static boolean oneInsertAway(String a, String b) {
        boolean foundDifference = false;
        int bIndex = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(bIndex)) {
                if (foundDifference) return false;
                foundDifference = true;
                bIndex++;
            }
            bIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        Assertions.assertEquals(true, oneEditWay("pale", "ple"));
        Assertions.assertEquals(true, oneEditWay("pales", "pale"));
        Assertions.assertEquals(true, oneEditWay("pale", "bale"));
        Assertions.assertEquals(false, oneEditWay("pale", "bae"));
        Assertions.assertEquals(true, oneEditWay("asd", "asde"));
        Assertions.assertEquals(true, oneEditWay("", "a"));
        Assertions.assertEquals(true, oneEditWay("b", "a"));
        Assertions.assertEquals(true, oneEditWay("b", "b"));
        Assertions.assertEquals(false, oneEditWay("", "aa"));
        Assertions.assertEquals(false, oneEditWay("a", "aae"));
    }
}
