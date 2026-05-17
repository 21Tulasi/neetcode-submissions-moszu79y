class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int fresh = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) fresh++;
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        !visited[nr][nc] &&
                        grid[nr][nc] == 1) {

                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            minutes++; // ✅ increment AFTER processing full layer
        }

        // ✅ Fix: last layer increments minutes once extra → subtract 1
        // But only if BFS actually ran (minutes > 0)
        return fresh == 0 ? (minutes == 0 ? 0 : minutes - 1) : -1;
    }
}