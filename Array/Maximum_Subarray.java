time complexity: O(n)


cur表示当前subarray(i - j, i could equal to j) 的最大值, 如果后面的一个元素加上cur比该元素本身小, 则把cur赋值为该元素, 然后再和最后的结果进行比较.


public int maxSubArray(int[] nums) {
    int cur = 0;
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; ++i) {
        cur = Math.max(cur + nums[i], nums[i]);
        res = Math.max(res, cur);
    }
    return res;
}