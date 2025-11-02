class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid=new int[m][n];

        for(int[] guard:guards)grid[guard[0]][guard[1]]=1;
        for(int[] wall:walls)grid[wall[0]][wall[1]]=2;

        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        for(int[] guard:guards ){
            int row=guard[0],col=guard[1];
            for(int[] dir:dirs){
                int nr=row+dir[0],nc=col+dir[1];
                while(nc>=0 && nc<n && nr>=0 && nr<m){
                    if(grid[nr][nc]==2||grid[nr][nc]==1)break;
                    if(grid[nr][nc]==0)grid[nr][nc]=3;
                    nr += dir[0];
                    nc += dir[1];
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)ans++;
            }
        }
        return ans;
    }
}