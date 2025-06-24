class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> safe=new ArrayList<>();
        int[] state=new int[n];
        for(int i=0;i<n;i++){
            if(dfs(i,graph,state)){
                safe.add(i);
            }
        }
        return safe;
    }
    public boolean dfs(int node,int[][] graph,int[] state){
        if(state[node]>0)return state[node]==2;
        state[node]=1;
        for(int next:graph[node]){
            if(state[next]==1||!dfs(next,graph,state)){
                return false;
            }
        }
        state[node]=2;
        return true;
    }
}