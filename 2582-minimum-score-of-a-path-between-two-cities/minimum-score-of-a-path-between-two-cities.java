class Solution {
    public void dfs(Map<Integer,List<int[]>> adjList,boolean[] visited,int node,int[] result){
        visited[node]=true;

        for(int[] neighborNode:adjList.getOrDefault(node,new ArrayList<>())){
            int neighbor=neighborNode[0],cost=neighborNode[1];

            result[0]=Math.min(result[0],cost);

            if(!visited[neighbor])dfs(adjList,visited,neighbor,result);
        }
    }
    public int minScore(int n, int[][] roads) {
        Map<Integer,List<int[]>> adjList=new HashMap<>();

        for(int[] road:roads){
            int cityA=road[0],cityB=road[1],dist=road[2];

            adjList.computeIfAbsent(cityA,k->new ArrayList<>()).add(new int[]{cityB,dist});
            adjList.computeIfAbsent(cityB,k->new ArrayList<>()).add(new int[]{cityA,dist});
        }

        boolean[] visited=new boolean[n+1];
        int[] result={Integer.MAX_VALUE};
        dfs(adjList,visited,1,result);
        return result[0];
    }
}