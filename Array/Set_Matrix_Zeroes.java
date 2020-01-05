time complexity: O(m*n)
space complexity; O(1)

用原二维数组的第一行和第一列来记录该行或者该列是否存在0, 然后从row为1开始遍历, 如果matrix[0][j] == 0 || matrix[i][0] == 0, 表示该行或该列存在0, 则把值设置为0.

public void setZeroes(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    boolean r = false;
    boolean c = false;
    for (int i = 0; i < col; ++i) {
        if (matrix[0][i] == 0) {
            c = true;
            break;
        }
    }
    for (int i = 0; i < row; ++i) {
        if (matrix[i][0] == 0) {
            r = true;
            break;
        }
    }
    
    for (int i = 1; i < row; ++i) {
        for (int j = 1; j < col; ++j) {
            if (matrix[i][j] == 0) {
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }
    
    for (int i = 1; i < row; ++i) {
        for (int j = 1; j < col; ++j) {
            if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                matrix[i][j] = 0;
            }
        }
    }
    if (c) {
        for(int i = 0; i < col; ++i) {
            matrix[0][i] = 0;
        }
    }
    if (r) {
        for (int i = 0; i < row; ++i) {
            matrix[i][0] = 0;
        }
    }
}