class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int left=0,right=0;
        int minSize=Integer.MAX_VALUE;
        int sum=0;
        while(right<n){
            sum+=nums[right];
            while(sum>=target){
                 minSize=Math.min(minSize,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return minSize==Integer.MAX_VALUE?0:minSize;
    }
}