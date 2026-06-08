class Solution {
    int[] parent;
    int[] rank;

    public int find(int node){
        if(node==parent[node]){
            return node;
        }

        return parent[node]=find(parent[node]);
    }

    public void union(int u,int v){
        int parentU=find(u),parentV=find(v);

        if(parentU==parentV)return;

        if(rank[parentU]>rank[parentV]){
            parent[parentV]=parentU;
        }else if(rank[parentV]>rank[parentU]){
            parent[parentU]=parentV;
        }else{
            parent[parentV]=parentU;
            rank[parentU]++;
        }
    }
    public long countPairs(int n, int[][] edges) {
        rank=new int[n];
        parent=new int[n];


        for(int i=0;i<n;i++){
            rank[i]=1;
            parent[i]=i;
        }

        //connecta ll the given edges
        for(int[] edge:edges){

            union(edge[0],edge[1]);
        }

        //stores parent nodes and how many nodes in that parent component {parent_node,size}
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++){
            int parent=find(i);//find parent/component of ith node

            //add 1 for a child node for that parent node
            map.put(parent,map.getOrDefault(parent,0)+1);
        }

        long result=0;
        long remaining=n;//initially all nodes are reachable

        //getting only sizes of all components
        //now calculate how many edges are missing from one component to another one
        for(int size:map.values()){
            result+=(long)size*(remaining-size);//formula for finding missing pairs from one component to remaining nodes: size *(no of nodes-size) 

            remaining-=size;//removing current size of current component to avoid duplicacy in next component as it is an undirected graph
        }

        return result;
    }
}