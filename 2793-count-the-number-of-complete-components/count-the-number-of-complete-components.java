class Solution {
    private void dfs(int curr, int[] nodes, int[] edges, List<List<Integer>> adj, boolean[] visited) {
        nodes[0]++;
        visited[curr] = true;
        for (int nbr : adj.get(curr)) {
            edges[0]++;
            if (!visited[nbr]) {
                dfs(nbr, nodes, edges, adj, visited);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int completeComponents = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] nodes = new int[1];
                int[] edgesCount = new int[1];
                dfs(i, nodes, edgesCount, adj, visited);
                if (edgesCount[0] == nodes[0] * (nodes[0] - 1)) {
                    completeComponents++;
                }
            }
        }
        return completeComponents;
}

}