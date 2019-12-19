time complexity: O(n)
space complexity: O(1)

二分法, 先看mid位置的值是否等于target, 等于则直接返回. 如果不等, 则检查i到mid是否连续, 记住要用"<=" 因为有可能就只有一个元素, 如果连续, 检查target是否在范围之内,
如果在更新j的值为mid - 1, 如果不在, 则更新i的值为mid + 1. 如果左边不连续, 则表示右边肯定连续, 做同样的检查就可以.


public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    
    int i = 0;
    int j = nums.length - 1;
    while(i <= j) {
        int mid = i + (j - i) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[i] <= nums[mid]) {
            if (nums[i] <= target && target < nums[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        } else {
            if (nums[mid] < target && target <= nums[j]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
    }
    return -1;
}