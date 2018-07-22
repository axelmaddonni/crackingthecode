package ArraysAndStrings;

import java.util.ArrayList;

public class ReverseString {

    public static String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() -1; i>= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String inlineReverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        if (sb.length() > 0) {
            int start = 0;
            int end = sb.length() -1;
            char tmp;
            while (start < end) {
                tmp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, tmp);
                start ++;
                end --;
            }
        }
        return sb.toString();
    }

/*  Version en C
    void reverse(char *str) {
        char * end = str;
        char tmp;
        if (str) {
            while (*end) {
                ++end;
            }
            --end;
            while (str < end) {
                tmp = *str;
            *str++ = *end;
            *end-- = tmp;
            }
        }
    }*/


    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(inlineReverseString("hola"));
        System.out.println(inlineReverseString("hoooola"));
        System.out.println(inlineReverseString("asdasjkdnaksd"));
        System.out.println(inlineReverseString(""));
        System.out.println(inlineReverseString("a"));

    }
}
