class Solution {
    public int specialTriplets(int[] nums) {
        long MOD = 1_000_000_007;
        int n = nums.length;
        HashMap<Integer, Long> right = new HashMap<>();
        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0L) + 1);
        }
        HashMap<Integer, Long> left = new HashMap<>();
        long ans = 0;
        for (int j = 0; j < n; j++) {
            right.put(nums[j], right.get(nums[j]) - 1);
            if (right.get(nums[j]) == 0) right.remove(nums[j]);
            long target = nums[j] * 2L;
            long leftCount = left.getOrDefault((int) target, 0L);
            long rightCount = right.getOrDefault((int) target, 0L);
            ans = (ans + (leftCount * rightCount) % MOD) % MOD;
            left.put(nums[j], left.getOrDefault(nums[j], 0L) + 1);
        }
        return (int) ans;
    }
}
