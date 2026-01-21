
// //Recurion+Memoization(from 0,0 to len of str1,str2)
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

// class Solution {
//     public int solve(String word1,String word2,int i,int j,int m,int n,int[][] dp){
//         if(i==m){
//             return n-j;
//         }
//         if(j==n){
//             return m-i;
//         }

//         if(dp[i][j]!=-1)return dp[i][j];

//         if(word1.charAt(i)==word2.charAt(j)){
//             return dp[i][j]=solve(word1,word2,i+1,j+1,m,n,dp);
//         }else{
//             int insertCh=1+solve(word1,word2,i,j+1,m,n,dp);
//             int removeCh=1+solve(word1,word2,i+1,j,m,n,dp);
//             int replaceCh=1+solve(word1,word2,i+1,j+1,m,n,dp);

//             return dp[i][j]=Math.min(insertCh,Math.min(removeCh,replaceCh));
//         }
//     }

//     public int minDistance(String word1, String word2) {
//         int m=word1.length(),n=word2.length();
//         int[][] dp=new int[m+1][n+1];
//         for(int i=0;i<=m;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return solve(word1,word2,0,0,m,n,dp);
//     }
// }

// //Recurion+Memoization(from  len of str1,str2 to 0,0)
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)
// class Solution {
//     public int solve(String str1,String str2,int m,int n,int[][] dp){
//         if(m==0||n==0){
//             return m+n;
//         }

//         if(dp[m][n]!=-1)return dp[m][n];

//         if(str1.charAt(m-1)==str2.charAt(n-1)){
//             return dp[m][n]=solve(str1,str2,m-1,n-1,dp);
//         }else{
//             int addCh=1+solve(str1,str2,m,n-1,dp);
//             int removeCh=1+solve(str1,str2,m-1,n,dp);
//             int replaceCh=1+solve(str1,str2,m-1,n-1,dp);

//             return dp[m][n]=Math.min(addCh,Math.min(removeCh,replaceCh));
//         }


//     }

//     public int minDistance(String word1, String word2) {
//         int m=word1.length(),n=word2.length();
//         int[][] dp=new int[m+1][n+1];
//         for(int i=0;i<=m;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return solve(word1,word2,m,n,dp);
//     }
// }

class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();

        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    dp[i][j]=i+j;
                }else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }

        return dp[m][n];
    }
}