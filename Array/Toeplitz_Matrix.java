time complexity: O(m*n)
space complexity: O(1)

从第二排开始, 检查1到col - 1的值是否等于上一排matrix[i-1][j-1]的值. 如果不等则返回false

public boolean isToeplitzMatrix(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    for (int i = 1; i < row; ++i) {
        for (int j = 1; j< col; ++j) {
            if (matrix[i][j] != matrix[i-1][j-1]) {
                return false;
            }
        }
    } 
    return true;
}