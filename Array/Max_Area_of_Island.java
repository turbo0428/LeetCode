time complexity: O(m*n)
space complexity: O(1)

dfs

private int dfs(int[][] grid, int x, int y) {
    int m = grid.length;
    int n = grid[0].length;
    
    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return 0;
    grid[x][y] = 0;
    int area = 1;
    area += dfs(grid, x - 1, y);
    area += dfs(grid, x + 1, y);
    area += dfs(grid, x, y - 1);
    area += dfs(grid, x, y + 1);
    return area;
}

public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int res = 0;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (grid[i][j] == 1) {
                int area = dfs(grid, i, j);
                res = Math.max(res, area);
            }
        }
    }
    return res;
}