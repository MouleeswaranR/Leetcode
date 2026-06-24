class Solution {
    public  Map<Integer,List<Integer>> buildAdjList(int[][] edges){
        Map<Integer,List<Integer>> adjList=new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            adjList.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        
        return adjList ;
    }

    //here we need minimum diameter, it is found when both trees are connected from center of their diameter
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer,List<Integer>> adjList1=buildAdjList(edges1);
        Map<Integer,List<Integer>> adjList2=buildAdjList(edges2);

        int diameter1=findDiameter(adjList1);//diameter of tree1
        int diameter2=findDiameter(adjList2);//diameter of tree2

        //half of diameter1 +half of diameter2+ edge connecting 2 trees
        int combined=(diameter1+1)/2 + (diameter2+1)/2 +1;//+1 for edge connecting 2 trees

        //edge case for some trees where the longest path is still on same tree even after connecting
        return Math.max(Math.max(diameter1,diameter2),combined);

    }

     public int findDiameter(Map<Integer,List<Integer>> adjList){
        
        //finding one end of diameter(farthest node) from random node(0)
        int[] oneEndDiameter=farthestNode(adjList,0);//returns farthest node(one end of diameter),distance
        
        //finding farthest node from one end of diameter found above
        int[] diameterRes=farthestNode(adjList,oneEndDiameter[0]);//another end of diameter, distance between one end and other(ans)
        
        return diameterRes[1];
        
    }

    public int[] farthestNode(Map<Integer,List<Integer>> adjList,int source){
        Queue<Integer> q=new LinkedList<>();
        Map<Integer,Boolean> vis=new HashMap<>();
        
        q.offer(source);
        vis.put(source,true);
        
        int farthestNode=source,maxDist=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int i=0;i<size;i++){
                int currNode=q.poll();
                
                farthestNode=currNode;
                
                for(int adjNode:adjList.getOrDefault(currNode,new ArrayList<>())){
                    if(!vis.getOrDefault(adjNode,false)){
                        vis.put(adjNode,true);
                        q.offer(adjNode);
                    }
                }
            }
            if(!q.isEmpty())maxDist++;
        }
        
        return new int[]{farthestNode,maxDist};
}

}