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
        int ulpu=findPar(u),ulpv=findPar(v);
        if(ulpu==ulpv)return;
        if(size[ulpu]<size[ulpv]){
            parent[ulpu]=ulpv;
            size[ulpv]+=size[ulpu];
        }else{
            parent[ulpv]=ulpu;
            size[ulpu]+=size[ulpv];
        }
    }
}

class Solution {
    public boolean isValid(int adjr,int adjc,int n){
        return adjr>=0 && adjr<n && adjc>=0 && adjc<n; 
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)continue;
                for(int ind=0;ind<4;ind++){
                    int newr=i+dr[ind],newc=j+dc[ind];
                    if(isValid(newr,newc,n) && grid[newr][newc]==1){
                        int nodeNo=i*n+j,adjNodeNo=newr*n+newc;
                        ds.unionBySize(nodeNo,adjNodeNo);
                    }
                }
            }
        }
        int mx=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1)continue;
                Set<Integer> comp=new HashSet<>();
                for(int ind=0;ind<4;ind++){
                    int newr=row+dr[ind],newc=col+dc[ind];
                    if(isValid(newr,newc,n) && grid[newr][newc]==1){
                        comp.add(ds.findPar(newr*n+newc));
                    }
                }
                int sizeTot=0;
                for(int parent:comp){
                    sizeTot+=ds.size[parent];
                }
                mx=Math.max(mx,sizeTot+1);
            }
        }
        for(int i=0;i<n*n;i++){
            mx=Math.max(mx,ds.size[ds.findPar(i)]);
        }
        return mx;
    }
}