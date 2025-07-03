class Tuple{
    int difference,row,col;
    public Tuple(int row,int col,int diff ){
        this.row=row;
        this.col=col;
        this.difference=diff;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((x,y)->x.difference-y.difference);
        pq.add(new Tuple(0,0,0));
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple it=pq.peek();
            pq.remove();
            int row=it.row;
            int col=it.col;
            int diff=it.difference;
            if(row==n-1 && col==m-1)return diff;
            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int maxEff=Math.max(diff,Math.abs(heights[row][col]-heights[nrow][ncol]));
                    if(maxEff<dist[nrow][ncol]){
                        dist[nrow][ncol]=maxEff;
                        pq.add(new Tuple(nrow,ncol,maxEff));
                    }
                }
            }
        }
        return -1;
    }
}