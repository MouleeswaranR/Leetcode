class Solution {
    public boolean isTrionic(int[] nums) {
        int i=1;

        while(i<nums.length && nums[i-1]<nums[i]){
            i++;
        }

        if(i==1||i==nums.length)return false;

        while(i<nums.length && nums[i-1]>nums[i]){
            i++;
        }

        if(i==nums.length)return false;

        while(i<nums.length&& nums[i-1]<nums[i]){
            i++;
        }

        return i==nums.length?true:false;

    }
}