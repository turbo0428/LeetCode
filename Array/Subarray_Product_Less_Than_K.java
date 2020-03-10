time complexity: O(n)
space complexity: O(1)

双指针, 每个元素乘以之前subarray的乘积, 如果不大于k, 则把subarray的size加到最后的res里. 
如果不大于k, 则左移l, 直到乘积小于k.

public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == 0) return 0;
    int l = 0;
    int res = 0;
    int product = 1;
    for (int i = 0; i < nums.length; ++i) {
        product *= nums[i];
        while(l <= i && product >= k) {
            product /= nums[l];
            l++;
        }
        res += (i - l + 1);
    }
    return res;
}