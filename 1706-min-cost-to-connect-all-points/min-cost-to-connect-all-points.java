class Solution {
    public int PrimsAlgo(Map<Integer,List<int[]>> adjList,int n){
        
        //using Priority Queue (min-heap) because It keeps low cost nodes at top
        // which is required for minimum spanning tree
        //stores {weight,node}
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a[0],b[0])
        );

        //to check if current node is visited and comes under MST
        boolean[] inMst=new boolean[n];

        pq.offer(new int[]{0,0});//initial cost of 0 to reach 0 from 0th node
        int sum=0;

        while(!pq.isEmpty()){
            int[] top=pq.poll();
            int wt=top[0],node=top[1];

            //check if already visited, which means it is under mst
            if(inMst[node])continue;

            inMst[node]=true;//mark current node as visited
            sum+=wt;//stores weight

            //visit current node's neighbor node
            for(int[] neighbor:adjList.getOrDefault(node,new ArrayList<>())){
                int neighNode=neighbor[0],neighDist=neighbor[1];
                
                //if not under MST, current neighbor node
                if(!inMst[neighNode]){
                    pq.offer(new int[]{neighDist,neighNode});
                }
            }
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {
        Map<Integer,List<int[]>> adjList=new HashMap<>();

        int n=points.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=points[i][0],y1=points[i][1];
                int x2=points[j][0],y2=points[j][1];

                int cost=Math.abs(x1-x2)+Math.abs(y1-y2);

                adjList.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{j,cost});
                adjList.computeIfAbsent(j,k->new ArrayList<>()).add(new int[]{i,cost});
            }
        }

        return PrimsAlgo(adjList,n);
    }
}