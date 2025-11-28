class Solution {
    private int count=0;
    public int dfs(int curr,int parent,Map<Integer,ArrayList<Integer>> adj,int[] values,int k){
        int sum=0;

        for(int adjNode:adj.get(curr)){
            if(adjNode!=parent){
                sum+=dfs(adjNode,curr,adj,values,k);
                sum%=k;
            }
        }

        sum+=values[curr];
        sum%=k;
        if(sum==0)count++;
        return sum;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Map<Integer,ArrayList<Integer>> adj=new HashMap<>();

        for(int i=0;i<n;i++)adj.put(i,new ArrayList<>() );

        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        count=0;
        dfs(0,-1,adj,values,k);
        return count;
    }
}