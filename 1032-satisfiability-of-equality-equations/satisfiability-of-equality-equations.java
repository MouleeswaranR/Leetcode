//Disjoint Set Union

class Solution {
    int[] parent;
    int[] rank;


    //finding parent for a node
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
        }else if(rank[parentU]<rank[parentV]){
            parent[parentU]=parentV;
        }else{
            parent[parentV]=parentU;
            parentU++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        rank=new int[26];//to track which nides carries most nodes
        parent=new int[26];//to carry parent of each node


        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=1;
        }    

        //connecting nodes(equation variables) which mark as ==
        for(String str:equations){
            if(str.charAt(1)=='='){
                union(str.charAt(0)-'a',str.charAt(3)-'a');
            }
        }

        //processing nodes(equation variables) which says not equal, their parent should not be equal
        for(String str:equations){
            if(str.charAt(1)=='!'){
                int parentU=find(str.charAt(0)-'a');
                int parentV=find(str.charAt(3)-'a');
                
                //parent should not be equal as eqaution say !=
                if(parentU==parentV)return false;
            }
        }

        return true;
    }
}