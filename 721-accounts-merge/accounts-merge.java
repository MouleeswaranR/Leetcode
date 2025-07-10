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
        int ulp=findPar(parent[node]);
        parent[node]=ulp;
        return parent[node];
    }
    public void unionBySize(int u,int v){
        int ulpU=findPar(u),ulpV=findPar(v);
        if(ulpU==ulpV)return;
        if(size[ulpU]<size[ulpV]){
            parent[ulpU]=ulpV;
            size[ulpV]+=size[ulpU];
        }else{
            parent[ulpV]=ulpU;
            size[ulpU]+=size[ulpU];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        Map<String,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!mpp.containsKey(mail)){
                    mpp.put(mail,i);
                }else{
                    ds.unionBySize(i,mpp.get(mail));
                }
            }
        }
        List<String>[] mergedMail=new ArrayList[n];
        for(int i=0;i<n;i++)mergedMail[i]=new ArrayList<>();
        for(Map.Entry<String,Integer> it:mpp.entrySet()){
            String mail=it.getKey();
            int node=ds.findPar(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0)continue;
            Collections.sort(mergedMail[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergedMail[i])temp.add(it);
            ans.add(temp);
        }
        return ans;
    }
}