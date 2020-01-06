time complexity: O(n)
space complexity: O(n)

从左扫描, 计算以当前位置前面最多能赚多少,
从右扫描, 计算以当前位置后面最多能赚多少.

最后取最大值

public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) return 0;
    int[] total = new int[n];
    int profit = 0;
    int min = prices[0];
    for(int i = 1; i < prices.length; ++i) {
        profit = Math.max(profit, prices[i] - min);
        total[i] = profit;
        min = Math.min(min, prices[i]);
    }
    profit = 0;
    int max = prices[n-1];
    for(int i = n - 2; i >= 0; --i) {
        profit = Math.max(profit, max - prices[i]);
        total[i] += profit;
        max = Math.max(max, prices[i]);
    }
    int result = 0;
    for (int i = 0 ; i < n; ++i) {
        result = Math.max(result, total[i]);
    }
    return result;
}