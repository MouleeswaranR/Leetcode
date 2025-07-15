class Solution {
    int timer=1;
    public void dfs(int node,int parent,int[] vis,List<List<Integer>> adj,int[] time,int[] low,List<List<Integer>> ans){
        vis[node]=1;
        time[node]=low[node]=timer;
        timer++;
        for(int it:adj.get(node)){
            if(it==parent)continue;
            if(vis[it]==0){
                dfs(it,node,vis,adj,time,low,ans);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>time[node]){
                    ans.add(Arrays.asList(it,node));
                }
            }else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(List<Integer> it:connections){
            int u=it.get(0),v=it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        int[] vis=new int[n];
        int[] time=new int[n];
        int[] low=new int[n];
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,-1,vis,adj,time,low,ans);
        return ans;
    }
}