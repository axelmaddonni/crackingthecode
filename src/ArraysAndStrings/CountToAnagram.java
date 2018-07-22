package ArraysAndStrings;

import java.util.HashMap;
import java.util.Scanner;

public class CountToAnagram {
    public static int numberNeeded(String first, String second) {
        String larger = (first.length() > second.length()) ? first : second;
        String shorter = (first.length() > second.length()) ? second : first;

        HashMap<Character, Integer> countChars = getCharCount(shorter);
        int res = 0;

        for (Character c : larger.toCharArray()) {
            if (countChars.containsKey(c)) {
                countChars.put(c, countChars.get(c) - 1);
            } else {
                res++;
            }
        }

        for (Character c : countChars.keySet()) {
            res += Math.abs(countChars.get(c));
        }

        if (res == first.length() + second.length()) return -1;

        return res;
    }

    private static HashMap<Character,Integer> getCharCount(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (Character c: str.toCharArray()) {
            charCount.put(c, (charCount.getOrDefault(c, 0)) + 1);
        }
        return charCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
