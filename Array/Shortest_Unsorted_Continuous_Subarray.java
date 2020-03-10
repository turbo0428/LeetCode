time complexity: O(n)
space complexity: O(1)

从左往右, 找到第一个index不满足nums[i] <= nums[i+1], 从右往左, 找到第一个index不满足nums[i] >= nums[i-1]
然后在这区间找最大和最小值, 找到之后左移left, 如果left对应的值比区间最小值大. 同理右移right, 满足right对应的值比区间最大值小.

public int findUnsortedSubarray(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int left = 0;
    int right = nums.length - 1;
    while(left < nums.length - 1 && nums[left] <= nums[left + 1]) left++;
    while(right > 0 && nums[right] >= nums[right - 1]) right--;
    
    int res = 0;
    if (right > left) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = left; i <= right; ++i) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        while(left >= 0 && nums[left] > min) left--;
        while(right < nums.length && nums[right] < max) right++;
        
        res = right - left - 1;
    }
    return res;
}