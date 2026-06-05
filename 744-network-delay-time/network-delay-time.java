class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //map to store node with their adjacent nodes and weights
        Map<Integer,List<int[]>> adjList=new HashMap<>();


        for(int[] edge:times){
            int currNode=edge[0],adjNode=edge[1],distance=edge[2];
            adjList.computeIfAbsent(currNode,x->new ArrayList<>()).add(new int[]{adjNode,distance});;
        }

        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a[0],b[0])
        );

        pq.offer(new int[]{0,k});//pushing source node k to queue
        dist[k]=0;//updating source node distance to reach source node

        while(!pq.isEmpty()){
            int[] topVal=pq.poll();
            int distance=topVal[0],node=topVal[1];//current node and its distance from source node

            if(distance>dist[node])continue;

            //traversing current node's adjacent nodes
            for(int[] neighbor:adjList.getOrDefault(node,new ArrayList<>())){
                int adjNode=neighbor[0],adjNodeDistance=neighbor[1];

                //if calulated distnace from current node to adj node is smaller than adj node shortest distance,update it
                if(distance+adjNodeDistance<dist[adjNode]){
                    dist[adjNode]=distance+adjNodeDistance;
                    pq.offer(new int[]{distance+adjNodeDistance,adjNode});
                }
            }
        }

        int result=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            result=Math.max(result,dist[i]);//getting max because needed minimum time to reach all nodes , so here using djikstra's ,we found shortest distance to all nodes from source node, so find the one which is max to find time to cover all nodes in the entire network
        }

        return result==Integer.MAX_VALUE?-1:result;
    }
}