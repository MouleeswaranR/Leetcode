class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row=mat.length,col=mat[0].length;
        if(row*col!=r*c)return mat;
        int index=0;
        int[][] reshapedMat=new int[r][c];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int crow=index/c;
                int ccol=index%c;
                reshapedMat[crow][ccol]=mat[i][j];
                index++;
            }
        }
        return reshapedMat;
    }
}