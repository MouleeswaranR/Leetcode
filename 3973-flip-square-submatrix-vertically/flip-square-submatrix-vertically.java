class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int startRow=x,endRow=x+k-1;
        int startCol=y,endCol=y+k-1;

        while(startRow<endRow){
            for(int j=startCol;j<=endCol;j++){
                int temp=grid[startRow][j];
                grid[startRow][j]=grid[endRow][j];
                grid[endRow][j]=temp;
            }
            startRow++;
            endRow--;
        }
        return grid;
    }
}