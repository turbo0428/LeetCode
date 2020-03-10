time complexity: O(n)
space complexity: O(n)

对每个index取dp[index-1]和dp[index-2]较小的值然后加上cost[index]
最后判断dp[len-1]和dp[len-2] 谁比较小就是最后的结果


public int minCostClimbingStairs(int[] cost) {
    int len = cost.length;
    int[] dp = new int[len];
    dp[0] = cost[0];
    dp[1] = cost[1];
    for(int i = 2; i < len; ++i) {
        dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
    }
    return Math.min(dp[len-1], dp[len-2]);
}