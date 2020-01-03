time complexity: O(m*n)
space complexity:O(m*n)

p表示每一层的起始点, 如果只剩一行或一列, 则全部放入最后的输出集, 返回.
如果不止一行或一列, 则从i=0开始, 每次遍历m-1或者n-1个元素. 然后缩小m和n的值, 每次递归都-2, p的值每次加1.

private void helper(int[][] matrix, List<Integer> res, int m, int n, int p) {
    if (m <= 0 || n <= 0) return ;
    if (m == 1) {
        for (int i = 0; i < n; ++i) {
            res.add(matrix[p][p+i]);
        }
        return ;
    }
    
    if (n == 1) {
        for (int i = 0; i < m; ++i) {
            res.add(matrix[p+i][p]);
        }
        return ;
    }
    
    for (int i = 0; i < n - 1; ++i) {
        res.add(matrix[p][p+i]);
    }
    
    for (int i = 0; i < m - 1; ++i) {
        res.add(matrix[p+i][n-1+p]);
    }
    
    for (int i = 0; i< n - 1; ++i) {
        res.add(matrix[m-1+p][n-1+p-i]);
    }
    
    for (int i = 0; i < m - 1; ++i) {
        res.add(matrix[m-1+p-i][p]);
    }
    
    
    helper(matrix, res, m - 2, n - 2, p + 1);
}


public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int m = matrix.length;
    if (m == 0) return res;
    int n = matrix[0].length;
    if (n == 0) return res;
    helper(matrix, res, m, n, 0);
    return res;
}