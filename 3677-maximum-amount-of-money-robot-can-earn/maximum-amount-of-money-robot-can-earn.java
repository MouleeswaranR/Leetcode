class Solution {
    int m,n;
    int[][][] memo;

    public int solve(int[][] coins,int i,int j,int neu){
        if(i>=m || j>=n)return Integer.MIN_VALUE;

        if(i==m-1 && j==n-1){
            if(coins[i][j]<0 && neu>0)return 0;
            return coins[i][j];
        }

        if(memo[i][j][neu]!=Integer.MIN_VALUE){
            return memo[i][j][neu];
        }

        int best=Integer.MIN_VALUE;

        int down=solve(coins,i+1,j,neu);

        if(down!=Integer.MIN_VALUE){
            best=Math.max(best,coins[i][j]+down);
        }

        int right=solve(coins,i,j+1,neu);

        if(right!=Integer.MIN_VALUE){
            best=Math.max(best,coins[i][j]+right);
        }

        if(coins[i][j]<0 && neu>0){
            int downSkip=solve(coins,i+1,j,neu-1);
            int rightSkip=solve(coins,i,j+1,neu-1);

            int skipped=Math.max(downSkip,rightSkip);
            if(skipped!=Integer.MIN_VALUE){
                best=Math.max(best,skipped);
            }
        }

        return memo[i][j][neu]=best;

    }
    public int maximumAmount(int[][] coins) {
         m=coins.length;
         n=coins[0].length;


        memo=new int[m][n][3];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(memo[i][j],Integer.MIN_VALUE);
            }
        }

        return solve(coins,0,0,2);
    }
}