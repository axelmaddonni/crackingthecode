package ArraysAndStrings;

public class ZeroMatrix {

    public static void nullify(int[][] m) {

        boolean rows[] = new boolean[m.length];
        boolean cols[] = new boolean[m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int r = 0; r < rows.length; r++) {
            if (rows[r]) {
                for (int i = 0; i < m[r].length; i++) {
                    m[r][i] = 0;
                }
            }
        }

        for (int c = 0; c < cols.length; c++) {
            if (cols[c]) {
                for (int i = 0; i < m.length; i++) {
                    m[i][c] = 0;
                }
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
        int[][] m = {{1, 2, 3}, {4, 5, 0}, {7, 8, 9}};
        print(m);
        nullify(m);
        print(m);

        m = new int[][]{{0, 2}, {3, 4}};
        print(m);
        nullify(m);
        print(m);

        m = new int[][]{{1, 2, 0, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        print(m);
        nullify(m);
        print(m);
    }
}
