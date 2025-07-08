class DisjointSet{
    int[] parent,size;
    public DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int findPar(int node){
        if(node==parent[node])return node;
        return parent[node]=findPar(parent[node]);
    }
    public void unionBySize(int u,int v){
        int ulpU=findPar(u),ulpV=findPar(v);
        if(ulpU==ulpV)return;
        if(size[ulpU]<size[ulpV]){
            parent[ulpU]=ulpV;
            size[ulpV]+=size[ulpU];
        }else{
            parent[ulpV]=ulpU;
            size[ulpU]+=size[ulpV];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int cntExt=0;
        for(int[] edge:connections){
            int u=edge[0],v=edge[1];
            if(ds.findPar(u)==ds.findPar(v)){
                cntExt++;
            }else{
                ds.unionBySize(u,v);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(i==ds.parent[i])cnt++;
        }
        if(cntExt>=cnt-1)return cnt-1;
        return -1;
    }
}