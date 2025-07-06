class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
             adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int city=0,minReach=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int[] dist=new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[i]=0;
            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
            pq.add(new int[]{i,0});
            while(!pq.isEmpty()){
                int[] tup=pq.poll();
                int node=tup[0];
                int dis=tup[1];
                for(int[] adjList:adj.get(node)){
                    int v=adjList[0];
                    int cost=adjList[1];
                    int newDist=dis+cost;
                    if(newDist<=distanceThreshold && newDist<dist[v]){
                        dist[v]=newDist;
                        pq.add(new int[]{v,newDist});
                    }
                }
            }
            int reachable=0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[j]<=distanceThreshold)reachable++;
            }
            if(reachable<=minReach){
                minReach=reachable;
                city=i;
            }
        }
        return city;
    }
}