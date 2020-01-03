

private void helper(int[][] res, int n, int p, int value) {
    if (n <= 0) return ;
    if (n == 1) {
        for (int i = 0; i < n; ++i) {
            res[p][p+i] = value;
            value++;
        }
        return ;
    }
    
    for (int i = 0; i < n - 1; ++i) {
        res[p][p+i] = value;
        value++;
    }
    
    for (int i = 0; i < n - 1; ++i) {
        res[p+i][n-1+p] = value;
        value++;
    }
    
    for (int i = 0; i < n - 1; ++i) {
        res[n-1+p][n-1+p-i] = value;
        value++;
    }
    
    for (int i = 0; i < n - 1; ++i) {
        res[n-1+p-i][p] = value;
        value++;
    }
    
    helper(res, n - 2, p + 1, value);
}

public int[][] generateMatrix(int n) {
    int[][] res = new int[n][n];
    helper(res, n, 0, 1);
    return res;
}