time complexity: O(n)
space complexity: O(1)

扫描数组, 对每个index, 计算 prices[i] - min, 然后更新最后的结果.

public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int result = 0;
    int min = prices[0];
    for (int i = 0; i < prices.length; ++i) {
        result = Math.max(result, prices[i] - min);
        min = Math.min(min, prices[i]);
    }
    return result;
}