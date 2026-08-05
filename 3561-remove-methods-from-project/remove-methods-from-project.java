class Solution {
    boolean outsideConn=false;
    public void dfs(int color,int node,Map<Integer,List<Integer>> adjList,int[] vis){
        vis[node]=color;
        for(int neighbor:adjList.getOrDefault(node,new ArrayList<>())){
            if(vis[neighbor]==1 && color==2){
                outsideConn=true;
                return;
            }
            if(vis[neighbor]!=color){
                dfs(color,neighbor,adjList,vis);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Map<Integer,List<Integer>> adjList=new HashMap<>();

        for(int[] edge:invocations){
            int u=edge[0],v=edge[1];
           if (adjList.get(u) == null) {
                adjList.put(u, new ArrayList<>());
            }

            adjList.get(u).add(v);
        }

        int[] vis=new int[n];

        dfs(1,k,adjList,vis);

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i==k||vis[i]==1)continue;
            dfs(2,i,adjList,vis);
        }

        for(int i=0;i<n;i++){
            if(!outsideConn && vis[i]==1)continue;
            ans.add(i);
        }

        return ans;
    }
}