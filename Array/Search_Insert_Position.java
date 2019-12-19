左闭右开的二分

public int searchInsert(int[] nums, int target) {
    int first = 0;
    int last = nums.length;
    while(first < last) {
        int mid = first + (last - first) / 2;
        if (nums[mid] < target) {
            first = mid + 1;
        } else {
            last = mid;
        }
    }
    return first;
}