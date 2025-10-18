class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums.length==0)return 0;

        int left=0,right=0,zeroes=0,maxlen=0;
        while(right<nums.length){
            if(nums[right]==0)zeroes++;
            if(zeroes>k){
                if(nums[left]==0)zeroes--;
                left++;
            }
            if(zeroes<=k)maxlen=Math.max(maxlen,right-left+1);
            right++;

        }
        return maxlen;
    }
}