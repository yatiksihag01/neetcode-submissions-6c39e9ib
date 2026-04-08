class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, pacific, heights[r][0]);
            dfs(heights, r, n - 1, atlantic, heights[r][n - 1]);
        }

        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, pacific, heights[0][c]);
            dfs(heights, m - 1, c, atlantic, heights[m - 1][c]);
        }

        List<List<Integer>> result = new ArrayList();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        if (r < 0 || c < 0 ||
            r >= m || c >= n ||
            visited[r][c] ||
            heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            dfs(heights, r + dir[0], c + dir[1], visited, heights[r][c]);
        }
    }
}
