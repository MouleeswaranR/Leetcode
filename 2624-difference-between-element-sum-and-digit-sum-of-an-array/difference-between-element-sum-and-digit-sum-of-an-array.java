class Solution {
    public int differenceOfSum(int[] nums) {
        int ele=0,digsum=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            ele+=nums[i];
            while(n>0){
                int temp=n%10;
                digsum+=temp;
                n/=10;
            }
        }
        return Math.abs(ele-digsum);
    }
}