class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[] dp = new long[]{0, Long.MIN_VALUE};

        for (int n : nums) {
            long[] cnt = new long[2];
            cnt[0] = dp[0] + n;
            cnt[1] = dp[1] + n;

            cnt[1] = Math.max(cnt[1], dp[0] + (n ^ k));
            cnt[0] = Math.max(cnt[0], dp[1] + (n ^ k));

            dp = cnt;
        }

        return dp[0];
    }
}