class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int r, int c) {
        int area = 0;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{r, c});
        grid[r][c] = 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            area++;

            for (int[] dir : directions) {
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];

                if (nr >= 0 && nc >= 0 &&
                    nr < grid.length && nc < grid[0].length &&
                    grid[nr][nc] == 1
                ) {
                    grid[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return area;
    }
}
