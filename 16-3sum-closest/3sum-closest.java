class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result=nums[0]+nums[1]+nums[2];
        int maxDiff=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            int left=i+1,right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target){
                    return sum;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
                 int totDiff=Math.abs(sum-target);
            if(totDiff<maxDiff){
                maxDiff=totDiff;
                result=sum;
            }
            }
        }
        return result;
    }
}