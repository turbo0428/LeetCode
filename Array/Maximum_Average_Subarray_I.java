time complexity: O(n)
space complexity: O(1)

slide window

public double findMaxAverage(int[] nums, int k) {
    double res = Integer.MIN_VALUE;
    double sum = 0;
    for (int i = 0; i < nums.length; ++i) {
        sum += nums[i];
        if (i >= k - 1) {
            res = Math.max(res, sum / k);
            sum -= nums[i - k + 1];
        }
    }
    return res;
}