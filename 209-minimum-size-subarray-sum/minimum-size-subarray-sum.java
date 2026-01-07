class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,ans=Integer.MAX_VALUE;
        int currSum=0;
        while(right<nums.length){
            currSum+=nums[right];
            
            while(currSum>=target){
                ans=Math.min(ans,right-left+1);
                currSum-=nums[left];
                left++;
            }
            right++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}