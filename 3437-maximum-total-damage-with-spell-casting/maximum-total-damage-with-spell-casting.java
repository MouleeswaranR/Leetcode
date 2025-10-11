class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        HashMap<Integer, Long> map = new HashMap<>();
        List<Integer> unique = new ArrayList<>();
        for(int nums : power) {
            map.put(nums, map.getOrDefault(nums,0L) + 1);
            if(unique.size() == 0 || unique.get(unique.size()-1) != nums)
                unique.add(nums);
        }
        int n = unique.size();
        long[] dp = new long[n];
        dp[0] = unique.get(0) * map.get(unique.get(0));
        for(int i=1;i<n;i++) {
            int damage = unique.get(i);
            dp[i] = Math.max(dp[i-1], damage * map.get(damage));
            if(unique.get(i) - unique.get(i-1) > 2)
                dp[i] = Math.max(dp[i], dp[i-1] + damage * map.get(damage));
            else if(i-2 >=0 && unique.get(i) - unique.get(i-2) > 2)
                dp[i] = Math.max(dp[i], dp[i-2] + damage * map.get(damage));
            else if(i-3 >=0)
                dp[i] = Math.max(dp[i], dp[i-3] + damage * map.get(damage));
        }
        return dp[n-1];
    }
}