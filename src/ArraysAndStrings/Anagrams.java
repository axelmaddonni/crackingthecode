package ArraysAndStrings;

public class Anagrams {

    public static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] ocurrences = new int[256];

        int differentChars = 0;

        for (char c : a.toCharArray()) {
            if (ocurrences[c] == 0) {
                differentChars++;
            }
            ocurrences[c]++;
        }

        for (char c : b.toCharArray()) {
            if (ocurrences[c] == 0) return false;
            ocurrences[c]--;
            if (ocurrences[c] == 0) differentChars--;
        }

        return differentChars == 0;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("hola", "aloh"));
        System.out.println(areAnagrams("", ""));
        System.out.println(areAnagrams("ddd", "ddd"));

        System.out.println(areAnagrams("hola", "aloha"));
        System.out.println(areAnagrams("asd", "dse"));
        System.out.println(areAnagrams("", "a"));
        System.out.println(areAnagrams("ddd", "d"));
    }
}
