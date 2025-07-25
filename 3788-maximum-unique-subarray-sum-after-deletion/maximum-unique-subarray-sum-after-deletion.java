class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums)set.add(num);
        int res=0;
        for(int num:set){
            if(num>0)res+=num;
        }
        if(res==0)return Collections.max(set);
        return res;
    }
}