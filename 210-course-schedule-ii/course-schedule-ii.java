class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer>[] adj=new List[n];
        int[] indegree=new int[n];
        int[] ans=new int[n];
        for(int[] prerequisite:prerequisites){
            int course=prerequisite[0];
            int prerequisit=prerequisite[1];
            if(adj[prerequisit]==null){
                adj[prerequisit]=new ArrayList<>();
            }
            adj[prerequisit].add(course);
            indegree[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
          for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int i=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            ans[i++]=curr;
            if(adj[curr]!=null){
                for(int it:adj[curr]){
                    indegree[it]--;
                    if(indegree[it]==0)q.offer(it);
                }
            }
        }
        return i==n?ans:new int[0];
    }
}