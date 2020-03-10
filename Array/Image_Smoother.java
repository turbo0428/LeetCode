time complexity: O(m * n)
space complexity: O(1)

计算每个cell周围8个cell的值, 然后把sum/count的值左移8位. 下次再计算的时候 "&0xFF" 就能得到低8位的值. 最后每个cell右移8位就是最后的值.

public int[][] imageSmoother(int[][] M) {
    int r = M.length;
    int c = M[0].length;
    int[] dir = {-1, 0, 1};
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            int sum = 0;
            int count = 0;
            for (int m = 0; m < 3; ++m) {
                for (int n = 0; n < 3; ++n) {
                    int x = i + dir[m];
                    int y = j + dir[n];
                    if (x >= 0 && y >= 0 && x < r && y < c) {
                        count++;
                        sum += (M[x][y] & 0xFF); // 11111111
                    }
                }
            }
            M[i][j] |= ((sum / count) << 8);
        }
    }
    
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j< c; ++j) {
            M[i][j] >>= 8;
        }
    }
    
    return M;
}