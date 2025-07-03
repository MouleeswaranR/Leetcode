class Tuple{
    int row,col,distance;
    public Tuple(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.distance=dist;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if(n == 1) return (grid[0][0] == 0) ? 1 : -1;
       
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,0,0));
        
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        int[] drow={-1, -1,  0, 1, 1, 1,  0, -1};
        int[] dcol={ 0,  1,  1, 1, 0, -1, -1, -1};
        while(!q.isEmpty()){
            Tuple it=q.peek();
            q.remove();
            int row=it.row;
            int col=it.col;
            int dis=it.distance;
            // if (row == n - 1 && col == n - 1) return dis;
            for(int i=0;i<8;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 && dis+1<dist[nrow][ncol]){
                    dist[nrow][ncol]=1+dis;
                   
                    q.add(new Tuple(nrow,ncol,1+dis));
                }
            }
        }
         return dist[n - 1][m- 1] != (int) 1e9 ? dist[n - 1][m - 1] + 1 : -1;
    }
}