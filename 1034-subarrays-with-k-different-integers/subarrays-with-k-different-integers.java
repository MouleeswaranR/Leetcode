class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int[] nums,int k){
        int left=0,right=0;
        Map<Integer,Integer> mpp=new HashMap<>();
        int count=0;
        while(right<nums.length){
            mpp.put(nums[right],mpp.getOrDefault(nums[right],0)+1);
            while(mpp.size()>k){
                mpp.put(nums[left],mpp.get(nums[left])-1);
                if(mpp.get(nums[left])==0)mpp.remove(nums[left]);
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
}