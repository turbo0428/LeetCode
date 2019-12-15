time complexity: O(n)
space complexity: O(1)

用双指针分别表示数组的头跟尾, 每次取头跟尾value小的值, 然后乘以下标的diff就是当前面积的大小, 最后和当前计算出来的最大面积进行比较.

public int maxArea(int[] height) {
    int result = 0;
    int i = 0, j = height.length - 1;
    while(i < j) {
        int cur = Math.min(height[i], height[j]) * (j - i);
        result = Math.max(result, cur);
        if (height[i] < height[j]) {
            i++;
        } else {
            j--;
        }
    }
    return result;
}