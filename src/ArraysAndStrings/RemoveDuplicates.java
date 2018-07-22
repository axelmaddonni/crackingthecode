package ArraysAndStrings;

public class RemoveDuplicates {

    public static void removeDuplicates(char[] str) {
        if (str == null) return;
        if (str.length < 2) return;

        int tail = 1;
        for (int i = 0; i < str.length; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (str[j] == str[i]) break;
            }
            if (tail == j) {
                str[tail] = str[i];
                tail++;
            }
        }

        if (tail < str.length) {
            str[tail] = 0;
        }
    }


    public static void main(String[] args) {
        char[] a = new String("aaaaabbb").toCharArray();
        removeDuplicates(a);
        System.out.println(a);
    }
}
