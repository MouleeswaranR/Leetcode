class Solution {
    public boolean checkThreshold(int side,int rows,int cols,int[][] prefixSum,int threshold){
        if(side==0)return true ;

        for(int i=0;i+side-1<rows;i++){
            for(int j=0;j+side-1<cols;j++){

                int r2=i+side-1,c2=j+side-1;

                int preSum=prefixSum[r2][c2];

                preSum-=(i>0?prefixSum[i-1][c2]:0);
                preSum-=(j>0?prefixSum[r2][j-1]:0);
                preSum+=((i>0 && j>0)?prefixSum[i-1][j-1]:0);

                if(preSum<=threshold)return true;
            }
        }
        return false;
        
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int rows=mat.length,cols=mat[0].length;
        int[][] prefixSum=new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                prefixSum[i][j]=mat[i][j]+ (i>0?prefixSum[i-1][j]:0)+(j>0?prefixSum[i][j-1]:0)-((i>0 && j>0)?prefixSum[i-1][j-1]:0);
            }
        }

        int low=1,high=Math.min(rows,cols);
        int result=0;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(checkThreshold(mid,rows,cols,prefixSum,threshold)){
                result=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return result;
    }
}