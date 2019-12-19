time complexity: O(log n)
space complexity: O(1)

二分法求上下界, 求下界的时候用<, 求上界的时候用<=

public int[] searchRange(int[] nums, int target) {
    int[] result = {-1, -1};
    boolean find = false;
    int i = 0;
    int j = nums.length;
    while(i < j) {
        int mid = i + (j - i) / 2;
        if (nums[mid] == target) find = true;
        if (nums[mid] < target) {
            i = mid + 1;
        } else {
            j = mid;
        }
    }
    
    if (!find) return result;
    result[0] = i;
    
    j = nums.length;
    while(i < j) {
        int mid = i + (j - i) / 2;
        if (nums[mid] <= target) {
            i = mid + 1;
        } else {
            j = mid;
        }
    }
    result[1] = i - 1;
    
    return result;
}