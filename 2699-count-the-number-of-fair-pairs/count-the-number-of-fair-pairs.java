class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n=nums.length;
        Arrays.sort(nums);

        long ans=0;
        for(int i=0;i<n-1;i++){
            int lb=lowerBound(nums,i+1,n,lower-nums[i]);
            int up=upperBound(nums,i+1,n,upper-nums[i]);
            ans+=(up-lb);
        }
        return ans;
    }
    public int lowerBound(int[] nums,int start,int end,int target){
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target)start=mid+1;
            else end=mid;
        }
        return start;
    }
    public int upperBound(int[] nums,int start,int end,int target){
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<=target)start=mid+1;
            else end=mid;
        }
        return start;
    }
}