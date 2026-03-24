class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int MOD=12345;

        int[][] result=new int[m][n];

        long suffix=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                result[i][j]=(int)(suffix%MOD);
                suffix=(suffix*grid[i][j])%MOD;
            }
        }

        long prefix=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=(int)((prefix*result[i][j])%MOD);
                prefix=(prefix*grid[i][j])%MOD;
            }
        }
        return result;
    }
}