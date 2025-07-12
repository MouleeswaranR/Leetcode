class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int left=0,right=n*n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(canSwim(grid,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean canSwim(int[][] grid,int mid){
        int n=grid.length;
        boolean[][] vis=new boolean[n][n];
        return dfs(grid,vis,0,0,mid);
    }
    public boolean dfs(int[][] grid,boolean[][] vis,int i,int j,int t){
        int n=grid.length;
        if(i<0||i>=n||j<0||j>=n||vis[i][j]||grid[i][j]>t)return false;
        if(i==n-1 && j==n-1)return true;
        vis[i][j]=true;
        return dfs(grid,vis,i+1,j,t)||dfs(grid,vis,i-1,j,t)||dfs(grid,vis,i,j+1,t)||dfs(grid,vis,i,j-1,t);
    }
}