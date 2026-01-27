//Recurion+Memoization
//Time Complexity:O(n*m)
//Space Complexity:O(n*m) with recursion stack space
// class Solution {
//     public int solve(int i,int j,int m,int n,int[][] dp){
//         if(i==m-1 && j==n-1)return 1;

//         if(i<0||i>=m ||j<0 ||j>=n)return 0;

//         if(dp[i][j]!=-1)return dp[i][j];

//         int right=solve(i,j+1,m,n,dp);
//         int down=solve(i+1,j,m,n,dp);

//         return dp[i][j]=right+down;
//     }
//     public int uniquePaths(int m, int n) {
//         int[][] dp=new int[m][n];
//         for(int[] r:dp)Arrays.fill(r,-1);
//         return solve(0,0,m,n,dp);
//     }
// }

//Tabulation
//Time Complexity:O(n*m)
//Space Complexity:O(n*m)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo=new int[m][n];
        
        //cells in the first column has only one way from cell (0,0)-going down
        for(int i=0;i<m;i++){
            memo[i][0]=1;
        }

        //cells in the first row has only one way from cell (0,0)-going right
        for(int j=0;j<n;j++)memo[0][j]=1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //taking ways of left cell an upside cell of cuurent cell
                memo[i][j]=memo[i-1][j]+memo[i][j-1];
            }
        }

        return memo[m-1][n-1];
    }
}