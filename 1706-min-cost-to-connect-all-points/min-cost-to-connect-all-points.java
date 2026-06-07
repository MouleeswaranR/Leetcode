
//Prim's Algorithm

// class Solution {
//     public int PrimsAlgo(Map<Integer,List<int[]>> adjList,int n){
        
//         //using Priority Queue (min-heap) because It keeps low cost nodes at top
//         // which is required for minimum spanning tree
//         //stores {weight,node}
//         PriorityQueue<int[]> pq=new PriorityQueue<>(
//             (a,b)->Integer.compare(a[0],b[0])
//         );

//         //to check if current node is visited and comes under MST
//         boolean[] inMst=new boolean[n];

//         pq.offer(new int[]{0,0});//initial cost of 0 to reach 0 from 0th node
//         int sum=0;

//         while(!pq.isEmpty()){
//             int[] top=pq.poll();
//             int wt=top[0],node=top[1];

//             //check if already visited, which means it is under mst
//             if(inMst[node])continue;

//             inMst[node]=true;//mark current node as visited
//             sum+=wt;//stores weight

//             //visit current node's neighbor node
//             for(int[] neighbor:adjList.getOrDefault(node,new ArrayList<>())){
//                 int neighNode=neighbor[0],neighDist=neighbor[1];
                
//                 //if not under MST, current neighbor node
//                 if(!inMst[neighNode]){
//                     pq.offer(new int[]{neighDist,neighNode});
//                 }
//             }
//         }

//         return sum;
//     }

//     public int minCostConnectPoints(int[][] points) {
//         Map<Integer,List<int[]>> adjList=new HashMap<>();

//         int n=points.length;

//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 int x1=points[i][0],y1=points[i][1];
//                 int x2=points[j][0],y2=points[j][1];

//                 int cost=Math.abs(x1-x2)+Math.abs(y1-y2);

//                 adjList.computeIfAbsent(i,k->new ArrayList<>()).add(new int[]{j,cost});
//                 adjList.computeIfAbsent(j,k->new ArrayList<>()).add(new int[]{i,cost});
//             }
//         }

//         return PrimsAlgo(adjList,n);
//     }
// }


//using Kruskal's Algorithm
class Solution {

    int[] parent;
    int[] rank;

    //find parents of node
    public int find(int x){
        if(x==parent[x]){
            return x;
        }

        return parent[x]=find(parent[x]);
    }

    //connecting 2 nodes
    public void union(int u,int v){
        int pu=find(u),pv=find(v);

        if(pu==pv)return;

        if(rank[pu]>rank[pv]){
            parent[pv]=pu;
        }else if(rank[pv]>rank[pu]){
            parent[pu]=pv;
        }else{
            parent[pv]=pu;
            rank[pu]++;
        }
    }

    public int Kruskal(List<int[]> edges){

        int mstWeight=0;

        //process all nodes 
        for(int[] edge:edges){
            int u=edge[0],v=edge[1],wt=edge[2];

            //check if parent of u and v are same, that means they are already connected, else connect them
            if(find(u)!=find(v)){
                union(u,v);//connect them

                mstWeight+=wt;
            }
        }
        return mstWeight;
    }

    public int minCostConnectPoints(int[][] points) {
        
        int n=points.length;

        rank=new int[n];
        parent=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        List<int[]> edges=new ArrayList<>();

        //creating edges with {u,v wt} weight from u to v node
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=points[i][0],y1=points[i][1];
                int x2=points[j][0],y2=points[j][1];

                int cost=Math.abs(x1-x2)+Math.abs(y1-y2);

                edges.add(new int[]{i,j,cost});
            }

        }

        //step1: sortimg edges according to weight
        Collections.sort(edges,(a,b)->Integer.compare(a[2],b[2]));

        
        return Kruskal(edges);
    }
}