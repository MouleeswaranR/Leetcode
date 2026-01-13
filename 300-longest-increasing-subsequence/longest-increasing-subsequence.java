// //Recurion + Memoization
// //Time Complexity : O(n)
// //Space Complexity: O(n*2)
// class Solution {

//     public int solve(int currInd,int prevInd,int[] nums,int[][] dp){
//         if(currInd>=nums.length)return 0;
        
//         if(prevInd!=-1 && dp[currInd][prevInd]!=-1){
//             return dp[currInd][prevInd];
//         }

//         int take=0;
//         if(prevInd==-1||nums[currInd]>nums[prevInd]){
//             take=1+solve(currInd+1,currInd,nums,dp);
//         }

//         int skip=solve(currInd+1,prevInd,nums,dp);

//         if(prevInd!=-1){
//             dp[currInd][prevInd]=Math.max(take,skip);
//         }
//         return Math.max(take,skip);
//     }
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int[][] dp=new int[n+1][n+1];
//         for(int i=0;i<=n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return solve(0,-1,nums,dp);
//     }
// }


//Tabulation
// //Time Complexity : O(n*2)
// //Space Complexity: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        //each each index  i in dp stores the longest increasing subsequence from index o to that index i
        Arrays.fill(dp,1);
        
        int maxLIS=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    maxLIS=Math.max(maxLIS,dp[i]);
                }
               
            }
        }
        return maxLIS;
    }
}