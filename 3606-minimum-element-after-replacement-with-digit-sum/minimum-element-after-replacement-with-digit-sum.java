class Solution {
    public int minElement(int[] nums) {
        int minVal=Integer.MAX_VALUE;

        for(int num:nums){
            int currSum=0;

            while(num>0){
                currSum+=num%10;
                num/=10;
            }

            minVal=Math.min(minVal,currSum);
        }

        return minVal;
    }
}