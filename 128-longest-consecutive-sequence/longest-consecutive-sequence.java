class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int longest=0;
        for(int i=0;i<nums.length;i++)set.add(nums[i]);
        for(int it:set){
            if(!set.contains(it-1)){
                int x=it;
                int cnt=1;
                while(set.contains(x+1)){
                    x+=1;
                    cnt+=1;
                }
                longest=Math.max(longest,cnt);
            }
            
        }
        return longest;
    }
}