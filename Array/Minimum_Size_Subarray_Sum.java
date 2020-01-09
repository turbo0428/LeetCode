time complexity: O(n)
space complexity: O(1)

slide window

public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int p = 0;
    int sum = 0;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; ++i) {
        sum += nums[i];
        while(sum >= s) {
            res = Math.min(res, i - p + 1);
            sum -= nums[p];
            p++;
        }
    }
    if (res == Integer.MAX_VALUE) return 0;
    return res;
}