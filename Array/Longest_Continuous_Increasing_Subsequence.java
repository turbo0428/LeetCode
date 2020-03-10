time complexity: O(n)
space complexity: O(1)

双指针, 对index使得nums[index-1] >= nums[index], 更新res

public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int l = 0;
    int res = 1;
    for (int i = 1; i < nums.length; ++i) {
        if (nums[i - 1] >= nums[i]) {
            res = Math.max(res, i - l);
            l = i;
        }
    }
    res = Math.max(res, nums.length - l);
    return res;
}