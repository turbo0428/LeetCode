time complexity: O(n)
space complexity: O(n)

从左往右扫描, 记录当前index左侧的最小值(包括当前的值), 然后从右往左, 判断当前index右侧的最小值是否大于等于其左侧的最大值, 如果大于则res++

public int maxChunksToSorted(int[] arr) {
    int n = arr.length;
    int[] maxL = new int[n];
    maxL[0] = arr[0];
    for (int i = 1; i < n; ++i) {
        maxL[i] = Math.max(maxL[i-1], arr[i]);
    }
    int min = arr[n-1];
    int res = 1;
    for (int i = n - 1; i > 0; --i) {
        min = Math.min(min, arr[i]);
        if (maxL[i-1] <= min) {
            res++;
        }
    }
    return res;
}