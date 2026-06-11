class Solution {

    public void dfs(int node,Map<Integer,List<Integer>> adjList,List<Integer> eulerPath){
        
        //traversing through neighbour nodes
        while(adjList.containsKey(node) && !adjList.get(node).isEmpty()){
            int nextNode=adjList.get(node).remove(adjList.get(node).size()-1);//removing one node after visiting it
            dfs(nextNode,adjList,eulerPath);
        }

        eulerPath.add(node);//add current node after visiting its edges
    }

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer,Integer> indegree=new HashMap<>();
        Map<Integer,Integer> outdegree=new HashMap<>();

        Map<Integer,List<Integer>> adjList=new HashMap<>();

        //build adjacncy list , indegree and outdegree for all nodes
        for(int[] pair:pairs){
            int u=pair[0],v=pair[1];

            adjList.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            indegree.put(v,indegree.getOrDefault(v,0)+1);
            outdegree.put(u,outdegree.getOrDefault(u,0)+1);
        }

        int startNode=pairs[0][0];

        //fins the start node needed to start dfs
        for(int node:adjList.keySet()){
            // if outdegree[node]-indegree[node]=1,that is start node
            if(outdegree.getOrDefault(node,0)-indegree.getOrDefault(node,0)==1){
                startNode=node;
                break;
            }
        }

        List<Integer> eulerPath=new ArrayList<>();

        //find the euler path
        dfs(startNode,adjList,eulerPath);

        //reverse to get original euler path
        Collections.reverse(eulerPath);

        int[][] result=new int[eulerPath.size()-1][2];

        //storing reuslt in pairs
        for(int i=0;i<eulerPath.size()-1;i++){
            result[i][0]=eulerPath.get(i);
            result[i][1]=eulerPath.get(i+1);
        }
        return result;
    }
}