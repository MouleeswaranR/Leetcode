class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;

        int maxVal = 0;
        for (int[] row : grid)
            for (int v : row)
                maxVal = Math.max(maxVal, v);

        int[][] dp = new int[n][m];
        int[] bestVal = new int[maxVal + 1];
        int[] prefix = new int[maxVal + 1];

        Arrays.fill(bestVal, Integer.MAX_VALUE);
        bestVal[grid[n - 1][m - 1]] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;

                int down = i + 1 < n ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                int right = j + 1 < m ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(down, right);
                bestVal[grid[i][j]] = Math.min(bestVal[grid[i][j]], dp[i][j]);
            }
        }

        for (int step = 0; step < k; step++) {
            prefix[0] = bestVal[0];
            for (int v = 1; v <= maxVal; v++)
                prefix[v] = Math.min(prefix[v - 1], bestVal[v]);

            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i == n - 1 && j == m - 1) continue;

                    int walk = Math.min(
                            i + 1 < n ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE,
                            j + 1 < m ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE
                    );

                    dp[i][j] = Math.min(walk, prefix[grid[i][j]]);
                    bestVal[grid[i][j]] = Math.min(bestVal[grid[i][j]], dp[i][j]);
                }
            }
        }

        return dp[0][0];
    }
}