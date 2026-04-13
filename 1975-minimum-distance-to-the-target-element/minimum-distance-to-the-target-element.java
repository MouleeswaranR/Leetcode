class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int abs=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                abs=Math.min(abs,Math.abs(i-start));
            }
        }

        return abs;
    }
}