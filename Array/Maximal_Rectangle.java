time complexity: O(n*n)
space complexity: O(n)


public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) return 0;
    Stack<Integer> s = new Stack<>();
    int result = 0;
    for (int i = 0; i <= heights.length; ++i) {
        int h = i == heights.length ? 0 : heights[i];
        if (s.empty() || h >= heights[s.peek()]) {
            s.push(i);
        } else {
            while(!s.empty() && h < heights[s.peek()]) {
                int pos = s.pop();
                result = Math.max(result, heights[pos] * (s.empty() ? i : i - 1 - s.peek()));
            }
            s.push(i);
        }
    }
    return result;
}

public int maximalRectangle(char[][] matrix) {
    int row = matrix.length;
    if (row == 0) return 0;
    int col = matrix[0].length;
    if (col == 0) return 0;
    int[] heights = new int[col];
    int result = 0;
    for(int i = 0; i < row; ++i) {
        for (int j = 0; j < col; ++j) {
            if (matrix[i][j] == '0') {
                heights[j] = 0;
            } else {
                heights[j] += 1;
            }
        }
        result = Math.max(result, largestRectangleArea(heights));
    }
    return result;
}