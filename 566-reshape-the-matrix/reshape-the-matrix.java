class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row=mat.length,col=mat[0].length;
        if(row*col!=r*c)return mat;
        int index=0;
        int[][] reshapedMat=new int[r][c];
        int nrow=0,ncol=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
              reshapedMat[nrow][ncol]=mat[i][j];
              ncol++;
              if(ncol==c){
                ncol=0;
                nrow++;
              }
            }
        }
        return reshapedMat;
    }
}