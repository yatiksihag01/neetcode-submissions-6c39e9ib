class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int edgeCount = 0;
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            edgeCount++;
        }

        if (edgeCount != n - 1) return false;

        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int current = edge[0];
            int previous = edge[1];

            if (visited.contains(current)) return false;
            visited.add(current);

            for (int neighbor : adj.get(current)) {
                if (neighbor == previous) continue;
                queue.offer(new int[]{neighbor, current});
            }
        }

        if (visited.size() != n) return false;
        return true;
    }
}
