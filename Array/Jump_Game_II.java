time complexity: O(n)

贪心:
用cur记录每个位置最多能跳多少级台阶, 然后用max表示上一次跳的时候能跳到的最大距离, 如果现在下标i==max(表示应该触发一次jump), 则更新max的值.


public int jump(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int step = 0;
    int cur = 0;
    int max = 0;
    for (int i = 0; i < nums.length - 1; ++i) {
        cur = Math.max(cur, i + nums[i]);
        if (max == i) {
            step++;
            max = cur;
        }
    }
    return step;
}