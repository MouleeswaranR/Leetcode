class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev_inc=0,cur_inc=1,longestK=0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                cur_inc++;
            }else{
                prev_inc=cur_inc;
                cur_inc=1;
            }
            longestK=Math.max(longestK,Math.max(cur_inc/2,Math.min(prev_inc,cur_inc)));
        }
        return longestK>=k;
    }
}