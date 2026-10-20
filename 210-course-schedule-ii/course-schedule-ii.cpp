

// class Solution {
//     public int[] findOrder(int n, int[][] prerequisites) {
//         List<Integer>[] adj=new List[n];
//         int[] indegree=new int[n];
//         int[] ans=new int[n];
//         for(int[] prerequisite:prerequisites){
//             int course=prerequisite[0];
//             int prerequisit=prerequisite[1];
//             if(adj[prerequisit]==null){
//                 adj[prerequisit]=new ArrayList<>();
//             }
//             adj[prerequisit].add(course);
//             indegree[course]++;
//         }
//         Queue<Integer> q=new LinkedList<>();
//           for (int i = 0; i < n; i++) {
//             if (indegree[i] == 0) {
//                 q.offer(i);
//             }
//         }
//         int i=0;
//         while(!q.isEmpty()){
//             int curr=q.poll();
//             ans[i++]=curr;
//             if(adj[curr]!=null){
//                 for(int it:adj[curr]){
//                     indegree[it]--;
//                     if(indegree[it]==0)q.offer(it);
//                 }
//             }
//         }
//         return i==n?ans:new int[0];
//     }
// }

class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int,vector<int>> adj;
        vector<int> indegrees(numCourses,0);

        for(auto& vec:prerequisites){
            int course=vec[0],preReq=vec[1];
            adj[preReq].push_back(course);
            indegrees[course]++;
        }

        queue<int> que;
        int count=0;

        vector<int> result;
        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                que.push(i);
                result.push_back(i);
                count++;
            }
        }

        while(!que.empty()){
            int node=que.front();
            que.pop();

            for(int neigh:adj[node]){
                indegrees[neigh]--;
                if(indegrees[neigh]==0){
                    result.push_back(neigh);
                    que.push(neigh);
                    count++;
                }
            }
        }
        return count==numCourses?result:vector<int>{};
    }
};