import java.util.*;

public class Solution {
    int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
    int N = 0, f = 0, s = 0;
    int[][][] dp = new int[27][27][27];

    void calc(int mask, int round, int i, int j, int l, int m, int r) {
        if (i >= j) {
            calc(mask, round + 1, 0, N, l, m, r); 
        } else if ((mask & (1 << i)) == 0) {
            calc(mask, round, i + 1, j, l, m, r);
        } else if ((mask & (1 << j)) == 0) {
            calc(mask, round, i, j - 1, l, m, r);
        } else if (i == f && j == s) { 
            mx = Math.max(mx, round);
            mn = Math.min(mn, round);
        } else if (dp[l][m][r] == -1) { 
            dp[l][m][r] = 1; 

            if (i != f && i != s) {
                calc(mask ^ (1 << i), round, i + 1, j - 1, 
                     l - (i < f ? 1 : 0), 
                     m - ((i > f) && (i < s) ? 1 : 0), 
                     r - (i > s ? 1 : 0));
            }

            if (j != f && j != s) {
                calc(mask ^ (1 << j), round, i + 1, j - 1, 
                     l - (j < f ? 1 : 0), 
                     m - ((j > f) && (j < s) ? 1 : 0), 
                     r - (j > s ? 1 : 0));
            }
        }
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        N = n - 1;
        f = firstPlayer - 1;
        s = secondPlayer - 1;

        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        calc((1 << n) - 1, 1, 0, n - 1, f, s - f - 1, N - s);
        return new int[]{mn,mx};
    }
}
