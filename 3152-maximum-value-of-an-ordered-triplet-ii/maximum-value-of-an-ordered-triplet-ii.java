class Solution {
    public long maximumTripletValue(int[] nums) {
       int n=nums.length;
       long maxVal=0,maxDiff=0,maxLeft=0;
       for(int i=0;i<n;i++){
        maxVal=Math.max(maxVal,nums[i]*maxDiff);
        maxDiff=Math.max(maxDiff,maxLeft-nums[i]);
        maxLeft=Math.max(maxLeft,nums[i]);
       } 
       return maxVal;
    }
}