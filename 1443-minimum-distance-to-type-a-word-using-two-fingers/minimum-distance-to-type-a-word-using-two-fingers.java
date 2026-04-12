class Solution {

    int[][][] dp = new int[301][27][27];

    public int[] getCoord(int pos) {
        return new int[]{pos / 6, pos % 6};
    }

    public int getDistance(int pos1, int pos2) {
        int[] c1 = getCoord(pos1);
        int[] c2 = getCoord(pos2);
        return Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);
    }

    public int solve(String word, int i, int f1, int f2) {
        if (i >= word.length())
            return 0;

        int curr = word.charAt(i) - 'A';

        if (dp[i][f1][f2] != -1)
            return dp[i][f1][f2];

        if (f1 == 26 && f2 == 26) {
            return dp[i][f1][f2] = solve(word, i + 1, curr, f2);
        }

        if (f2 == 26) {
            int moveF2 = solve(word, i + 1, f1, curr);
            int moveF1 = getDistance(f1, curr) + solve(word, i + 1, curr, f2);

            return dp[i][f1][f2] = Math.min(moveF1, moveF2);
        }

        int moveF1 = getDistance(f1, curr) + solve(word, i + 1, curr, f2);

        int moveF2 = getDistance(f2, curr) + solve(word, i + 1, f1, curr);

        return dp[i][f1][f2] = Math.min(moveF1, moveF2);
    }

    public int minimumDistance(String word) {
        for (int i = 0; i < 301; i++)
            for (int j = 0; j < 27; j++)
                Arrays.fill(dp[i][j], -1);

        return solve(word, 0, 26, 26);
    }
}
