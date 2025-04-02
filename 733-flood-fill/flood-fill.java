class Solution {
    public void dfs(int sr,int sc,int[][] image,int[][] ans,int iniCol,int color,int[] delRow,int[] delCol){
        ans[sr][sc]=color;
        int n=image.length,m=image[0].length;
        for(int i=0;i<4;i++){
            int row=sr+delRow[i];
            int col=sc+delCol[i];
            if(row>=0 && row<n && col>=0 && col<m && image[row][col]==iniCol && ans[row][col]!=color){
                dfs(row,col,image,ans,iniCol,color,delRow,delCol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniCol=image[sr][sc];
        int[][] ans=image;
        int[] delRow={-1,1,0,0};
        int[] delCol={0,0,1,-1};
        dfs(sr,sc,image,ans,iniCol,color,delRow,delCol);
        return ans;
    }
}