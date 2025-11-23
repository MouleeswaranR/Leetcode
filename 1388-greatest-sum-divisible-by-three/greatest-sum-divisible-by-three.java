class Solution {
    public int solve(int ind,int remainder,int[][] dp,int[] nums){
        if(ind>=nums.length){
            return remainder==0?0:Integer.MIN_VALUE;
        }
        if(dp[ind][remainder]!=-1){
            return dp[ind][remainder];
        }
        int pick=nums[ind]+solve(ind+1,(nums[ind]+remainder)%3,dp,nums);
        int notpick=solve(ind+1,remainder,dp,nums);
        return dp[ind][remainder]=Math.max(pick,notpick) ;
    }
    public int maxSumDivThree(int[] nums) {
       int n=nums.length;
       int[][] dp=new int[n][3];
       for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
       }
    return solve(0,0,dp,nums);
    }
}