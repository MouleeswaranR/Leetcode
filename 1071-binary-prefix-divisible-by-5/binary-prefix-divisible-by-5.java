class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int remainder=0;
        for(int i=0;i<nums.length;i++){
            remainder=(remainder*2+nums[i])%5;
            ans.add(remainder==0);
        }
        return ans;
    }
}