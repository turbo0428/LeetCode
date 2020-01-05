time complexity: O(lgn)
space complexity: O(1)

二分找所在的行, 二分找所在的列

public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    if (row == 0) return false;
    int col = matrix[0].length;
    if (col == 0) return false;
    if (target < matrix[0][0] || target > matrix[row-1][col-1]) return false;
    int first = 0;
    int last = row;
    while(first < last) {
        int mid = first + (last - first) / 2;
        if (matrix[mid][0] == target) return true;
        if (matrix[mid][0] < target) {
            first = mid + 1;
        } else {
            last = mid;
        }
    }
    int target_row = first - 1;
    first = 0;
    last = col;
    while(first < last) {
        int mid = first + (last - first) / 2;
        if (matrix[target_row][mid] == target) return true;
        if (matrix[target_row][mid] < target) {
            first = mid + 1;
        } else {
            last = mid;
        }
    }
    return false;
}