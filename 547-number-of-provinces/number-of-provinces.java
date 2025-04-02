class Solution {
    public int findCircleNum(int[][] isConnected) {
        int c = 0,n = isConnected.length,m = isConnected[0].length;
        boolean[] vis = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                c++;
                dfs(isConnected,n,m,i,vis);
            }
        }
        return c;
    }
    void dfs(int[][] mat,int n,int m,int src,boolean[] vis){
          vis[src] = true;
          mat[src][src] = 0;
          for(int i = 0;i<m;i++){
              if(!vis[i] && mat[src][i] == 1){
                   mat[src][i] = 0;
                   dfs(mat,n,m,i,vis);
              }
          }
    }
}