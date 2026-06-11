class Solution {
    public boolean checkIsBiPartite(int currNode,int currCol,int[] color,List<List<Integer>> adjList){
        color[currNode]=currCol;//color current node

        //traverse through adjacent nodes
        for(int neighbor:adjList.get(currNode)){
            //if neighbor is still not visited
            if(color[neighbor]==-1){
                //check for bipartiteness thorugh neighbor
                if(checkIsBiPartite(neighbor,1-currCol,color,adjList)==false){
                    return false;
                }
            }else  if(color[neighbor]==color[currNode]){//if color of current node and its neighbor is same, there is no bipartiteness
                return false;
            }
        }

        return true;//there is bipartiteness
    }
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adjList=new ArrayList<>();
        
        int n=graph.length;

        for(int i=0;i<n;i++)adjList.add(new ArrayList<>());
        
        //building adjacency list
        for(int i=0;i<n;i++){
            for(int neighbor : graph[i]){
                adjList.get(i).add(neighbor);
            }
        }

        //to keep track of color of each node
        int[] color=new int[n];
        Arrays.fill(color,-1);//fill initially with -1 mean not visited

        //for each node, check if it is not visited and check for bipartiteness
        for(int i=0;i<n;i++){
            if(color[i]==-1 && checkIsBiPartite(i,1,color,adjList)==false){
                return false;
            }
        }

        return true;
    }
}