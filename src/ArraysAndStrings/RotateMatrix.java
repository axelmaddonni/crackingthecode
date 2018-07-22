package ArraysAndStrings;

public class RotateMatrix {

    public static void rotate(int[][] m) {
        int n = m.length;
        for (int l = 0; l < n / 2; l++) {
            int start = l;
            int end = n - 1 - l;
            for (int i = start; i < end; i++) {
                int top = m[l][i];
                m[l][i] = m[n-1-i][l];
                m[n-1-i][l] = m[n-1-l][n-1-i];
                m[n-1-l][n-1-i] = m[i][n-1-l];
                m[i][n-1-l] = top;
            }
        }
    }

    private static void print(int[][] matrix) {
        System.out.println("- - -");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("- - -");
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(m);
        rotate(m);
        print(m);

        m = new int[][]{{1, 2}, {3, 4}};
        print(m);
        rotate(m);
        print(m);

        m = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        print(m);
        rotate(m);
        print(m);
    }
}
