class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans=new int[n][n];

        for(int[] query:queries){
            int row1=query[0],col1=query[1],row2=query[2],col2=query[3];
            for(int i=row1;i<=row2;i++){
                ans[i][col1]+=1;
                if(col2+1<n){
                    ans[i][col2+1]-=1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                ans[i][j]+=ans[i][j-1];
            }
        }
        return ans;
    }
}