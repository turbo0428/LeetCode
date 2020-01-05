time complexity: O(n)
space complexity: O(n)

真的不会做

数组当前index的值(heights[i])如果大于栈顶元素在数组中的值(heights[s.peek()]), 则压栈
否则, pop栈顶元素， 然后计算面积, 计算时分情况
1. 如果栈不为空, 则高为栈顶元素在数组中的值, 宽为i - 1 - s.peek()
2. 如果栈为空, 则宽为i

public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) return 0;
    Stack<Integer> s = new Stack<>();
    int result = 0;
    for (int i = 0; i <= heights.length; ++i) {
        int h = i == heights.length ? 0 : heights[i];
        if (s.empty() || h >= heights[s.peek()]) {
            s.push(i);
        } else {
            int pos = s.pop();
            result = Math.max(result, heights[pos] * (s.empty() ? i : i - 1 - s.peek()));
            i--;
        }
    }
    return result;
}