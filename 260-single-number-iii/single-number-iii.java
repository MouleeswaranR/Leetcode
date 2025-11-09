class Solution {
    public int[] singleNumber(int[] nums) {
        long xor=0;
        for(int num:nums)xor^=num;
        int rightmostbit=(int)(xor&(xor-1))^(int)xor;

        int xor1=0, xor2=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&rightmostbit)!=0){
                xor1^=nums[i];
            }else{
                xor2^=nums[i];
            }
        }
        return new int[]{xor1,xor2};
    }
}