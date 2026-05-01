class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;

        int F=0,sum=0;

        for(int i=0;i<n;i++){
            F+=i*nums[i];
            sum+=nums[i];
        }

        int result=F;

        for(int k=0;k<n;k++){
            int newF=F+sum-n*nums[n-1-k];
            result=Math.max(result,newF);
            F=newF;
        }

        return result;
    }
}