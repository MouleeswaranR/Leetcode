// //Recurion + Memoization
// //Time Complexity: O(n)
// //Space Complexity: O(n)
// class Solution {
//     public long solve(int ind,int[] nums,long[][] dp,boolean flag){
//         // flag=true means even index needed to be added , flag=false means odd index needed to be subtracted
//         if(ind>=nums.length)return 0;
//         int flagVal=flag==true?0:1;
//         if(dp[ind][flagVal]!=-1)return dp[ind][flagVal];

//         long skip=solve(ind+1,nums,dp,flag);//skipping current index but flag same;
//         int val=flag==true?nums[ind]:-nums[ind];//taking current index and changing flag
//         long take=val+solve(ind+1,nums,dp,!flag);

//         return dp[ind][flagVal]=Math.max(skip,take);
//     }
//     public long maxAlternatingSum(int[] nums) {
//         int n=nums.length;

//         long[][] dp=new long[n+1][2];       
//         for (int i = 0; i < n; i++) {
//             dp[i][0] = -1;
//             dp[i][1] = -1;
//         }

//         return solve(0,nums,dp,true);
//     }
// }


class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[][] dp=new long[n+1][2];

        for(int i=1;i<=n;i++){
            dp[i][0]=Math.max(dp[i-1][1]-nums[i-1],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][0]+nums[i-1],dp[i-1][1]);
        }

        return Math.max(dp[n][0],dp[n][1]);
    }
}