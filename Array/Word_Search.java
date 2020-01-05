time complexity: O(m*n*4*L)


private boolean dfs(char[][] board, String word, int i, int j, int p, boolean[][] visited) {
    int row = board.length;
    int col = board[0].length;
    if (p == word.length()) return true;
    if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || board[i][j] != word.charAt(p)) return false;
    visited[i][j] = true;
    
    boolean res = dfs(board, word, i+1, j, p+1, visited)
        || dfs(board, word, i-1, j, p+1, visited)
        || dfs(board, word, i, j-1, p+1, visited)
        || dfs(board, word, i, j+1, p+1, visited);
    
    visited[i][j] = false;
    return res;
}


public boolean exist(char[][] board, String word) {
    int row = board.length;
    int col = board[0].length;
    if (row == 0 || col == 0) return false;
    boolean[][] visited = new boolean[row][col];
    for(int i = 0; i < row; ++i) {
        for (int j = 0; j < col; ++j) {
            if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, visited)) {
                return true;
            }
        }
    }
    return false;
}