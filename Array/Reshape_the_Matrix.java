time complexity: O(m*n)
space complexity: O(m * n)

计算当前cell的值, 然后分别该值在返回matrix中的新下标. 分别是 p / c 和 p % c;


public int[][] matrixReshape(int[][] nums, int r, int c) {
    int m = nums.length;
    if (m == 0) return nums;
    int n = nums[0].length;
    if (n == 0) return nums;
    if (m * n != r * c) return nums;
    int[][] res = new int[r][c];
    
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            int p = i * n + j;
            int r1 = p / c;
            int c1 = p % c;
            res[r1][c1] = nums[i][j];
        }
    }
    return res;
}