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

        if(parentU==parentV){
            return;
        }


        if(rank[parentU]>rank[parentV]){
            parent[parentV]=parentU;
        }else if(rank[parentV]>rank[parentU]){
            parent[parentU]=parentV;
        }else{
            parent[parentV]=parentU;
            parentU++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        
        //minimum n-1 edges needed to connect n nodes, if there is less than n-1 nodes, return -1
        if(connections.length<n-1){
            return -1;  
        }

        rank=new int[n];
        parent=new int[n];

        for(int i=0;i<n;i++){
            rank[i]=1;
            parent[i]=i;
        }

        int components=n;//initailly each node is a component;

        //go through all edges
        for(int[] connection:connections){
            //find parent for each edge nodes
            int parent1=find(connection[0]),parent2=find(connection[1]);

            //if parent are not same but have edge between them,connect them
            //connecting one node to one node or component reduces a component
            if(parent1!=parent2){
                union(connection[0],connection[1]);//connect the nodes
                components--;//reduce one components as 2 nodes become 1 component
            }
        }

        return components-1;//-1 because n nodes need n-1 edges to connect them
    }
}