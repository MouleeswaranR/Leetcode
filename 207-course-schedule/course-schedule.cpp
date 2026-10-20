//Topological Sorting: in an order of vertices, for any edge between u and v ,u must appear before v
//only occur in Directed acyclic graph

//DFS: stack(push the current node after visiting its neighbors) visit until all nodes are visited
//BFS: calculate indegree of all vertices. push all 0 degree vertices into queue. and visited their edges and reduce indegrees

//Java 

// class Solution {
//     public boolean canFinish(int n, int[][] prerequisites) {
//         List<Integer>[] adj = new List[n];
//         int[] indegree = new int[n];
//         List<Integer> ans = new ArrayList<>();

//         for (int[] pair : prerequisites) {
//             int course = pair[0];
//             int prerequisite = pair[1];
//             if (adj[prerequisite] == null) {
//                 adj[prerequisite] = new ArrayList<>();
//             }
//             adj[prerequisite].add(course);
//             indegree[course]++;
//         }

//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < n; i++) {
//             if (indegree[i] == 0) {
//                 queue.offer(i);
//             }
//         }

//         while (!queue.isEmpty()) {
//             int current = queue.poll();
//             ans.add(current);

//             if (adj[current] != null) {
//                 for (int next : adj[current]) {
//                     indegree[next]--;
//                     if (indegree[next] == 0) {
//                         queue.offer(next);
//                     }
//                 }
//             }
//         }

//         return ans.size() == n;
//     }
// }

class Solution {
public:
    bool canTopoSort(unordered_map<int,vector<int>>& adj,int n,vector<int> indegree){
        queue<int> que;
        int count=0;

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                count++;
                que.push(i);
            }
        }

        while(!que.empty()){
            int node=que.front();
            que.pop();

            for(int neigh:adj[node]){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    count++;
                    que.push(neigh);
                    }
            }
        }
        if(count==n)return true; //also check queue.size()==n which means no cycle

        return false;
    }
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        unordered_map<int,vector<int>> adj;
        vector<int> indegrees(numCourses,0);

        for(auto& vec:prerequisites){
            int course=vec[0],preReq=vec[1];
            //to do course, need to finish prerequiste
            //preReq--->course
            adj[preReq].push_back(course);
            indegrees[course]++;
        }

        return canTopoSort(adj,numCourses,indegrees);
    }
};