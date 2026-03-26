class Solution {
    public boolean checkHorizontalCuts(int[][] grid,long total){
        int m=grid.length,n=grid[0].length;

        Set<Long> set=new HashSet<>();
        long top=0;

        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                set.add((long)grid[i][j]);
                top+=grid[i][j];
            }

            long bottom=total-top;
            long diff=top-bottom;

            if(diff < 0) continue;

            if(diff==0)return true;
            if(diff==grid[0][0])return true;
            if(diff==grid[0][n-1])return true;

            if(diff==grid[i][0])return true;

            if(i>0 && n>1 && set.contains(diff)){
                return true;
            }
        }
        return false;
    }

    public void reverse(int[][] grid){
        int top=0,bottom=grid.length-1;

        while(top<bottom){
            int[] temp=grid[top];
            grid[top]=grid[bottom];
            grid[bottom]=temp;
            top++;
            bottom--;
        }
    }
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        long total=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total+=grid[i][j];
            }
        }

        if(checkHorizontalCuts(grid,total))return true;

        reverse(grid);

        if(checkHorizontalCuts(grid,total))return true;

        reverse(grid);


        int[][] transposeGrid=new int[n][m];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                transposeGrid[j][i]=grid[i][j];
            }
        }

        if(checkHorizontalCuts(transposeGrid,total))return true;

        reverse(transposeGrid);


        return checkHorizontalCuts(transposeGrid,total);

    }
}