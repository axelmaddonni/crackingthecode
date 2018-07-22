package ArraysAndStrings;

import org.junit.jupiter.api.Assertions;

public class StringRotation {


    private static boolean isSubstring(String sub, String str) {
        return str.toLowerCase().contains(sub.toLowerCase());
    }

    public static boolean isRotation(String a, String b) {
        if (a.length() != b.length()) return false;

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < b.length()) {
            sb.append(b.charAt(i));
            if (! isSubstring(sb.toString(), a)) {
                sb.deleteCharAt(sb.length()-1);
                break;
            } else {
                i++;
            }
        }

        StringBuilder sb2 = new StringBuilder();
        while (i < b.length()) {
            sb2.append(b.charAt(i));
            i++;
        }

        return a.equals(sb2.toString() + sb.toString());
    }

    public static boolean isRotation2(String a, String b) {
        if (a.length() != b.length() || a.length() == 0) return false;
        return isSubstring(b, a + a);
    }

    public static void main(String[] args) {
        Assertions.assertEquals(true, isRotation2("waterbottle", "erbottlewat"));
    }
}
