class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){

            while(nums[i]>0 && nums[i]<n && nums[i]!=nums[nums[i]-1]){
                int crt=nums[i]-1;

                int temp=nums[i];
                nums[i]=nums[crt];
                nums[crt]=temp;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;

        
    }
}