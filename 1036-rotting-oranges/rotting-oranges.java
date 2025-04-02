public class Pair{
    int first;
    int second;
    int tm;
    Pair(int first,int second,int tm){
        this.first=first;
        this.second=second;
        this.tm=tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        int cntFresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int tm=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int t=q.peek().tm;
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }         
        }
        if(cntFresh!=cnt)return -1;
        return tm;
    }
}