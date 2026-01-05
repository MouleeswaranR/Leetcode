class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        long sum=0;
        int countNeg=0;
        int smallAbsVal=Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum+=Math.abs(matrix[i][j]);

                if(matrix[i][j]<0)countNeg++;

                smallAbsVal=Math.min(smallAbsVal,Math.abs(matrix[i][j]));
            }
        }
        if(countNeg%2==0){
            return sum;
        }
        return sum-2L*smallAbsVal;
    }
}