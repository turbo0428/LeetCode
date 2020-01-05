time complexity: average O(lgn), worse case: O(n)



public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return false;
    int start = 0;
    int end = nums.length - 1;
    
    while(start <= end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return true;
        if (nums[start] < nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        } else if (nums[start] > nums[mid]) {
            if (nums[mid] < target && target <= nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } else {
            start++;
        }
    }
    return false;
}