class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int[] edge:times){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] tup=pq.remove();
            int node=tup[0];
            int dis=tup[1];
            if(dis>dist[node])continue;
            for(int[] adjList:adj.get(node)){
                int adjNode=adjList[0];
                int edgeW=adjList[1];
                if(dis+edgeW<dist[adjNode]){
                    dist[adjNode]=dis+edgeW;
                    pq.add(new int[]{adjNode,dis+edgeW});
                }
            }
        }
        int minTime=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            minTime=Math.max(minTime,dist[i]);
        }
        return minTime;
    }
}