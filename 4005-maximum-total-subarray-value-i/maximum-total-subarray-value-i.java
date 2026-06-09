class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxVal=Integer.MIN_VALUE,minVal=Integer.MAX_VALUE;

        for(int num:nums){
            maxVal=Math.max(maxVal,num);
            minVal=Math.min(minVal,num);
        }

        return (long)(maxVal-minVal)*k;
    }
}