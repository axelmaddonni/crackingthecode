package ArraysAndStrings;

import java.util.HashMap;

public class AllUniqueChars {

    public static boolean allUniqueChars(String s) {
        HashMap<Character, Boolean> chars = new HashMap<>();
        for (Character character : s.toCharArray()) {
            if (chars.containsKey(character)) {
                return false;
            } else {
                chars.put(character, true);
            }
        }
        return true;
    }

    public static boolean allUniqueChars2(String s) {
        boolean[] chars = new boolean[256];
        for (char c : s.toCharArray()) {
            if (chars[c]) return false;
            chars[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(allUniqueChars2("hola"));
        System.out.println(allUniqueChars2("hoooola"));
        System.out.println(allUniqueChars2("asdasjkdnaksd"));
        System.out.println(allUniqueChars2("asd"));

        System.out.println(Character.toLowerCase('!'));
        System.out.println(Character.getNumericValue('0'));
    }
}
