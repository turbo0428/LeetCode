time complexity: O(n)
space complexity: O(1)

记录以 0 ~ i 为subarray情况下的最大和最小值, 然后更新最后的结果

public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int maxValue = nums[0];
    int minValue = nums[0];
    int res = nums[0];
    for (int i = 1; i < nums.length; ++i) {
        int tmp = maxValue;
        maxValue = Math.max(Math.max(maxValue * nums[i], minValue * nums[i]), nums[i]);
        minValue = Math.min(Math.min(tmp * nums[i], minValue * nums[i]), nums[i]);
        res = Math.max(res, maxValue);
    }
    return res;
}