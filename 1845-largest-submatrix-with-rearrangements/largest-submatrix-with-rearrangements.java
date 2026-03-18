class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        int[] prevRow=new int[col];

        int result=0;

        for(int i=0;i<row;i++){
            int[] currRow=matrix[i].clone();
            for(int j=0;j<col;j++){
                if(currRow[j]!=0){
                    currRow[j]+=prevRow[j];
                }
            }
            int[] sortedRow=currRow.clone();
            Arrays.sort(sortedRow);
            for( int k=0;k<col;k++){
                int base=col-k;
                int height=sortedRow[k];
                result=Math.max(result,base*height);
            }
            prevRow=currRow;
        }
        return result;
    }
}