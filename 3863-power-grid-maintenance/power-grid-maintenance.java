class Solution {
    public void dfs(int node,Map<Integer,ArrayList<Integer>> adjList,int component_id, boolean[] vis, int[] componentId, Map<Integer,TreeSet<Integer>> componentMap){
        vis[node]=true;
        componentId[node]=component_id;
        if(!componentMap.containsKey(component_id))componentMap.put(component_id,new TreeSet<>());
        componentMap.get(component_id).add(node);

        for(int adjNode:adjList.getOrDefault(node, new ArrayList<>())){
            if(!vis[adjNode])dfs(adjNode,adjList,component_id,vis,componentId,componentMap);
        }

    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Map<Integer,ArrayList<Integer>> adjList=new HashMap<>();

        for(int[] connection:connections){
            int node1=connection[0],node2=connection[1];
            if(!adjList.containsKey(node1))adjList.put(node1,new ArrayList<>());
             if(!adjList.containsKey(node2))adjList.put(node2,new ArrayList<>());
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        boolean[] vis=new boolean[c+1];
        int[] componentId=new int[c+1];
        Map<Integer,TreeSet<Integer>> componentMap=new HashMap<>();

        for(int node=1;node<=c;node++){
            int id=node;
            if(!vis[node])dfs(node,adjList,id,vis,componentId,componentMap);
        }

        List<Integer> ans=new ArrayList<>();
        for(int[] query:queries){
            int operationType=query[0],node=query[1];
            int nodeId=componentId[node];

            if(operationType==1){
                if(componentMap.get(nodeId).contains(node)){
                    ans.add(node);
                }else if(!componentMap.get(nodeId).isEmpty()){
                    ans.add(componentMap.get(nodeId).first());
                }else{
                    ans.add(-1);
                }
            }else{
                componentMap.get(nodeId).remove(node);
            }
        }
        int[] res=new int[ans.size()];
        int idx=0;
        for(int num:ans){
            res[idx++]=num;
        }
        return res;
    }
}