class Solution {
    public boolean backtrack(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        // base case: matched all characters
        if (idx == word.length()) {
            return true;
        }

        // bounds or already visited or mismatch
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            visited[i][j] ||
            board[i][j] != word.charAt(idx)) {
            return false;
        }

        // choose
        visited[i][j] = true;

        // explore 4 directions
        boolean res =
            backtrack(board, word, idx + 1, i + 1, j, visited) ||
            backtrack(board, word, idx + 1, i - 1, j, visited) ||
            backtrack(board, word, idx + 1, i, j + 1, visited) ||
            backtrack(board, word, idx + 1, i, j - 1, visited);

        // un-choose (backtrack)
        visited[i][j] = false;

        return res;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}