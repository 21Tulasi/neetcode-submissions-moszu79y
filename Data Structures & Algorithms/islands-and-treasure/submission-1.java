class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int INF = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();

        // Use boolean[][] for visited — safe, fast, correct
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true; // mark treasure chests visited
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size(); // ✅ snapshot size BEFORE loop, not during

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                // ✅ Don't overwrite treasure chests (level=0 is fine but skip for clarity)
                if (grid[r][c] == INF) {
                    grid[r][c] = level;
                }

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // ✅ visited[][] correctly tracks seen cells
                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        !visited[nr][nc] &&       // not seen yet
                        grid[nr][nc] != -1) {     // not a wall

                        visited[nr][nc] = true;   // mark BEFORE adding to queue
                        grid[nr][nc] = level + 1;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }
    }
}