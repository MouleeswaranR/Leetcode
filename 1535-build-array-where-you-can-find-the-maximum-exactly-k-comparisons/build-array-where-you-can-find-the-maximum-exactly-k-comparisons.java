class Solution {
    private final int MOD = 1000000007;
    public int solve(int idx,int len,int maxVal,int n,int m,int k,int[][][] dp){
        if (len > k) return 0;
        if(idx==n){
            if(len==k){
                return 1;
            }
            return 0;
        }
        if(dp[idx][len][maxVal]!=-1){
            return dp[idx][len][maxVal];
        }
        int result=0;
        for(int i=1;i<=m;i++){
            if(i>maxVal){
                result=(result+(solve(idx+1,len+1,i,n,m,k,dp)))%MOD;
            }else{
                result=(result+(solve(idx+1,len,maxVal,n,m,k,dp)))%MOD;
            }
        }
        return dp[idx][len][maxVal]=result%MOD;
    }
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp=new int[n+1][k+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return solve(0,0,0,n,m,k,dp);
    }
}