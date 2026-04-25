class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(adj, i, visited);
                components++;
            }
        }

        return components;
    }

    private void dfs(List<List<Integer>> adj, int current, Set<Integer> visited) {
        if (visited.contains(current)) return;

        visited.add(current);
        for (int neighbor : adj.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}
