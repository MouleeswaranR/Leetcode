class Solution {
    public boolean isBipartite(int[][] graph) {
     int n=graph.length;
     int[] colors=new int[n];
     for(int i=0;i<n;i++){
        if(colors[i]==0){
            if(checkValidColor(i,1,colors,graph)==false) return false;
        }
     }
     return true;
    }
    public boolean checkValidColor(int node,int color,int[] colors,int[][] graph){
        if(colors[node]!=0){
            return colors[node]==color;
        }
        colors[node]=color;
        for(int adjNode:graph[node]){
            if(!checkValidColor(adjNode,-color,colors,graph)) return false;
        }
        return true;
    }
}