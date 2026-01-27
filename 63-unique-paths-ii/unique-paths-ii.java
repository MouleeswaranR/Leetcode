class Solution {
    public int solve(int i,int j,int m,int n,int[][] memo,int[][] obstacleGrid){

        if(i < 0 || i >= m || j < 0 || j >= n || obstacleGrid[i][j] != 0) {
            return 0;
        }
        
        if(memo[i][j] != -1)
            return memo[i][j];
        
        if(i == m-1 && j == n-1)
            return 1;

        int right=solve(i,j+1,m,n,memo,obstacleGrid);
        int down=solve(i+1,j,m,n,memo,obstacleGrid);

        return memo[i][j]=right+down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] memo=new int[m][n];
        for(int[] r:memo)Arrays.fill(r,-1);
        return solve(0,0,m,n,memo,obstacleGrid);
    }
}