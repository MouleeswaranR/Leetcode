//Recurion+Memoization
// //Time Complexity: O(m*n)
// //Space Complexity: O(m*n)
// class Solution {

//     public int solve(int row,int col,int rows,int cols,int[][] grid,int[][] dp){
//         if(row==rows-1 && col==cols-1)return grid[row][col];

//         if(dp[row][col]!=-1)return dp[row][col];

//         if(col==cols-1){//going down because at last column can't go to right
//             return dp[row][col]=grid[row][col]+solve(row+1,col,rows,cols,grid,dp);
//         }else if(row==rows-1){//going right because at last row can't able to go down
//             return dp[row][col]=grid[row][col]+solve(row,col+1,rows,cols,grid,dp);
//         }else{
//             return dp[row][col]=grid[row][col]+Math.min(solve(row+1,col,rows,cols,grid,dp),solve(row,col+1,rows,cols,grid,dp));
//         }
//     }
//     public int minPathSum(int[][] grid) {
        
//         int rows=grid.length,cols=grid[0].length;
//         int[][] memo=new int[rows][cols];

//         for(int i=0;i<rows;i++)Arrays.fill(memo[i],-1);
//         return solve(0,0,rows,cols,grid,memo);
//     }
// }

class Solution {
    public int minPathSum(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int[][] dp=new int[rows][cols];

        //min path sum from 0,0 to 0,0 is that element at 0,0 at grid
        dp[0][0]=grid[0][0];

        //filling first row's min path sum (adding up prev col val to current col value in 1st row)
        for(int col=1;col<cols;col++){
            dp[0][col]=grid[0][col]+dp[0][col-1];
        }

        //filling first col's min path sum (adding up prev row val to current row value in 1st column)
        for(int row=1;row<rows;row++){
            dp[row][0]=grid[row][0]+dp[row-1][0];
        }

        for(int row=1;row<rows;row++){
            for(int col=1;col<cols;col++){
                dp[row][col]=grid[row][col]+Math.min(dp[row-1][col],dp[row][col-1]);
            }
        }
        return dp[rows-1][cols-1];

    }
}