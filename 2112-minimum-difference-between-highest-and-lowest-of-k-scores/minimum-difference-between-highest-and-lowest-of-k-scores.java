class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        int i = 0;
        int j = i+k-1;

        while(j < n) {
            int minElement = nums[i];
            int maxElement = nums[j];

            minDiff = Math.min(minDiff, maxElement - minElement);

            i++;
            j++;
        }

        return minDiff;
    }
}