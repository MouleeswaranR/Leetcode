class Solution {
    private int[][][] dp;
    private int solve(int[][] count,int m,int n,int index){
        if((index>=count.length)||(m==0&&n==0))return 0;
        if(dp[m][n][index]!=-1)return dp[m][n][index];
        int take=0;
        if(count[index][0]<=m&&count[index][1]<=n){
            take=1+solve(count,m-count[index][0],n-count[index][1],index+1);
        }
        int notTake=solve(count,m,n,index+1);
        return dp[m][n][index]=Math.max(take,notTake);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int N=strs.length;
        int[][] count=new int[N][2];

        for(int i=0;i<N;i++){
            int zero=0,one=0;
            for(char ch:strs[i].toCharArray()){
                if(ch=='0'){
                    zero++;
                }else{
                    one++;
                }
            }
        count[i][0]=zero;
        count[i][1]=one;
        }
        dp=new int[m+1][n+1][N];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(count,m,n,0);
    }
}