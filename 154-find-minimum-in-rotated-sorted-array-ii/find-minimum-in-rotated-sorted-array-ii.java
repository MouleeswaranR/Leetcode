class Solution {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;

        int resultIdx=0;


        while(left<=right){


            while(left<right && nums[left]==nums[left+1]){
                left++;
            }

            while(left<right && nums[right]==nums[right-1]){
                right--;
            }

            int mid=left+(right-left)/2;

            if(nums[resultIdx]>nums[mid])resultIdx=mid;

            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return nums[resultIdx];
    }
}