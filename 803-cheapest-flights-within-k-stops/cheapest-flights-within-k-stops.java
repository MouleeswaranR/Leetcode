class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        Queue<int[]> q=new LinkedList<>();
        int[] dist=new int[n];
        Arrays.fill(dist,(int)1e9);
        q.add(new int[]{0,src,0});
        dist[src]=0;
        while(!q.isEmpty()){
            int[] tuple=q.peek();
            q.remove();
            int stops=tuple[0];
            int node=tuple[1];
            int cost=tuple[2];
            if(stops>k) continue;
            for(int[] adjList:adj.get(node)){
                int adjNode=adjList[0];
                int edgeWeight=adjList[1];
                if(cost+edgeWeight<dist[adjNode] && stops<=k){
                    dist[adjNode]=edgeWeight+cost;
                    q.add(new int[]{stops+1,adjNode,cost+edgeWeight});
                }
            }
        }
        if(dist[dst]==(int)1e9)return -1;
        return dist[dst];
    }
}