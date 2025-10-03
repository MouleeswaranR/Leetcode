class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null||heightMap.length==0||heightMap[0].length==0)return 0;

    int n=heightMap.length,m=heightMap[0].length;
    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
    boolean[][] vis=new boolean[n][m];
    for(int i=0;i<n;i++){
        vis[i][0]=true;
        pq.offer(new int[]{heightMap[i][0],i,0});
        if(m-1!=0){
            vis[i][m-1]=true;
            pq.offer(new int[]{heightMap[i][m-1],i,m-1});
        }
    }
    for(int j=0;j<m;j++){
        if(!vis[0][j]){
            vis[0][j]=true;
            pq.offer(new int[]{heightMap[0][j],0,j});
        }
         if(!vis[n-1][j]){
            vis[n-1][j]=true;
            pq.offer(new int[]{heightMap[n-1][j],n-1,j});
        }
    }
    int ans=0;
    int[] row={-1,0,1,0};
    int[] col={0,1,0,-1};
    while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int h=curr[0],currR=curr[1],currC=curr[2];
        for(int i=0;i<4;i++){
            int nrow=currR+row[i],ncol=currC+col[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol]){
                vis[nrow][ncol]=true;
                int nh=heightMap[nrow][ncol];
                if(h>nh)ans+=(h-nh);
                pq.offer(new int[]{Math.max(h,nh),nrow,ncol});
            }
        }
    }
    return ans;
    }
}