time complexity: O(lgn)
space complexity: O(1)

如果mid在数组中的值大于right在数组中的值, 则最小元素必然在右半部分, 更新left to mid + 1
否则更新right to mid

public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int left = 0;
    int right = nums.length - 1;
    
    while(left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] >= nums[right]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return nums[left];
}