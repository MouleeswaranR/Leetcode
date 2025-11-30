class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum=(sum+num)%p;
        }
        int target=sum%p;
        if (target == 0) {
            return 0;
        }
        int result=n;
        int curr=0;
        Map<Integer,Integer> mpp=new HashMap<>();
        mpp.put(0,-1);
        for(int j=0;j<n;j++){
            curr=(curr+nums[j])%p;
            int remain=(curr-target+p)%p;
            if(mpp.containsKey(remain)){
                result=Math.min(result,j-mpp.get(remain));
            }
            mpp.put(curr,j);
        }
        return result==n?-1:result;
    }
}