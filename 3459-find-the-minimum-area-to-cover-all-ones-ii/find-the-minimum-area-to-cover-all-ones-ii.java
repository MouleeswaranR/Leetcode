class Solution {
    public int minimumSum(int[][] grid) {
        long res = (long)4e18;
        int[][] A = grid;
        for (int rot = 0; rot < 4; rot++) {
            int m = A.length, n = A[0].length;
            for (int i = 1; i < m; i++) {
                int topArea = area(subRows(A, 0, i)); 

                for (int j = 1; j < n; j++) {
                    int[][] left  = sub(A, i, m, 0, j); 
                    int[][] right = sub(A, i, m, j, n); 
                    int a2 = area(left), a3 = area(right);
                    res = Math.min(res, (long)topArea + a2 + a3);
                }
                for (int k = i + 1; k < m; k++) {
                    int[][] mid = subRows(A, i, k);
                    int[][] bot = subRows(A, k, m);
                    int a2 = area(mid), a3 = area(bot);
                    res = Math.min(res, (long)topArea + a2 + a3);
                }
            }
            A = rotate(A);
        }
        return (int)res;
    }

    private int[][] subRows(int[][] g, int r1, int r2) {
        if (r1 >= r2) return new int[0][0];
        int cols = g[0].length;
        int[][] out = new int[r2 - r1][cols];
        for (int i = r1; i < r2; i++) out[i - r1] = Arrays.copyOf(g[i], cols);
        return out;
    }

    private int[][] sub(int[][] g, int r1, int r2, int c1, int c2) {
        if (r1 >= r2 || c1 >= c2) return new int[0][0];
        int[][] out = new int[r2 - r1][c2 - c1];
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                out[i - r1][j - c1] = g[i][j];
            }
        }
        return out;
    }

    private int area(int[][] g) {
        if (g.length == 0 || g[0].length == 0) return 0;
        int m = g.length, n = g[0].length;
        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE, right = -1, bottom = -1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (g[i][j] == 1) {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                }
        if (right == -1) return 0;
        return (right - left + 1) * (bottom - top + 1);
    }

    private int[][] rotate(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] r = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                r[j][m - 1 - i] = g[i][j];
        return r;
    }
}