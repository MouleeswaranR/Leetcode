class Pair{
    long max;
    long min;

    public Pair(long max,long min){
        this.max=max;
        this.min=min;
    }
}

//Recurion+Memoization
//Time Complexity:O(n*m)
//Space Complexity: O(n*m*2)+Recurion Stack Space
// class Solution {
//     final int MOD = 1000000007;
//     public Pair solve(int row,int col,int rows,int cols,int[][] grid,Pair[][] memo){
//         if(row==rows-1 && col==cols-1){
//             return new Pair((long)grid[row][col],(long)grid[row][col]);
//         }

//         if(memo[row][col]!=null)return memo[row][col];
//         long maxVal=Long.MIN_VALUE;
//         long minVal=Long.MAX_VALUE;

//         if(row+1<rows){
//             Pair down=solve(row+1,col,rows,cols,grid,memo);
//             maxVal=Math.max(maxVal,Math.max(grid[row][col]*down.max,grid[row][col]*down.min));
//             minVal=Math.min(minVal,Math.min(grid[row][col]*down.max,grid[row][col]*down.min));
//         }

//         if(col+1<cols){
//              Pair right=solve(row,col+1,rows,cols,grid,memo);
//             maxVal=Math.max(maxVal,Math.max(grid[row][col]*right.max,grid[row][col]*right.min));
//             minVal=Math.min(minVal,Math.min(grid[row][col]*right.max,grid[row][col]*right.min));
//         }

//         return memo[row][col]=new Pair(maxVal,minVal);
//     }
//     public int maxProductPath(int[][] grid) {
//         int rows=grid.length,cols=grid[0].length;
//         Pair[][] memo=new Pair[rows][cols];
//         Pair result=solve(0,0,rows,cols,grid,memo);
//         return result.max<0?-1:(int)(result.max%MOD);
//     }
// }

class Solution {
    final int MOD = 1000000007;
    public int maxProductPath(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;

        Pair[][] dp=new Pair[rows][cols];

        dp[0][0]=new Pair((long)grid[0][0],(long)grid[0][0]);

        for(int col=1;col<cols;col++){
            dp[0][col]=new Pair(grid[0][col]*dp[0][col-1].max,grid[0][col]*dp[0][col-1].min);
        }

        for(int row=1;row<rows;row++){
            dp[row][0]=new Pair(grid[row][0]*dp[row-1][0].max,grid[row][0]*dp[row-1][0].min);
        }

        for(int row=1;row<rows;row++){
            for(int col=1;col<cols;col++){
                long upMax=dp[row-1][col].max,upMin=dp[row-1][col].min;
                long leftMax=dp[row][col-1].max,leftMin=dp[row][col-1].min;
                
                long maxi=Math.max(Math.max(grid[row][col]*upMax,grid[row][col]*upMin),Math.max(grid[row][col]*leftMax,grid[row][col]*leftMin));
                long mini=Math.min(Math.min(grid[row][col]*upMax,grid[row][col]*upMin),Math.min(grid[row][col]*leftMax,grid[row][col]*leftMin));
                dp[row][col]=new Pair(maxi,mini);
            }
        }
        long maxProduct=dp[rows-1][cols-1].max;
        return maxProduct<0?-1:(int)(maxProduct%MOD);
    }
}