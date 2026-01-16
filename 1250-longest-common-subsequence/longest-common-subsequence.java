//Recursion+Memoization
//Time Complexity: O(2^n * 2^m)
//Space Complexity: O(n*m)//n-text1 len,m-text2 len
// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int len1=text1.length(),len2=text2.length();

//         int[][] dp=new int[len1][len2];
//         for(int i=0;i<len1;i++){
//             Arrays.fill(dp[i],-1);
//         }

//         return solve(0,0,len1,len2,text1,text2,dp);
//     }

//     public int solve(int idx1,int idx2,int len1,int len2,String text1,String text2,int[][] dp){
//         if(idx1>=len1||idx2>=len2)return 0;

//         if(dp[idx1][idx2]!=-1)return dp[idx1][idx2];
//         if(text1.charAt(idx1)==text2.charAt(idx2)){
//             return dp[idx1][idx2]= 1+solve(idx1+1,idx2+1,len1,len2,text1,text2,dp);
//         }

//         int include_i=solve(idx1+1,idx2,len1,len2,text1,text2,dp);
//         int include_j=solve(idx1,idx2+1,len1,len2,text1,text2,dp);

//         return dp[idx1][idx2]=Math.max(include_i,include_j);
//     }
// }

//Tabulation
// Time and Space complexity: O(n*m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length();

        int[][] memo=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    memo[i][j]=0;
                }else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    memo[i][j]=1+memo[i-1][j-1];
                }else{
                    memo[i][j]=Math.max(memo[i][j-1],memo[i-1][j]);
                }

            }
        }
        return memo[m][n];
    }
}