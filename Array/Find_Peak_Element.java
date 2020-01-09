time complexity: O(lgn)
space complexity: O(1)

如果mid的值小于mid+1的值, 则更新left to mid + 1
否则mid可能是结果, 更新right to mid.

public int findPeakElement(int[] nums) {
    if (nums.length <= 1) return 0;
    int left = 0;
    int right = nums.length - 1;
    while(left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < nums[mid + 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}