类似 3sum

public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) return 0;
    Arrays.sort(nums);
    int result = nums[0] + nums[1] + nums[2];
    int i = 0;
    while(i + 2 < nums.length) {
        int j = i + 1;
        int k = nums.length - 1;
        while(j < k) {
            int cur = nums[i] + nums[j] + nums[k];
            if (Math.abs(cur - target) < Math.abs(result - target)) {
                result = cur;
            }
            if (cur < target) {
                j++;
            } else {
                k--;
            }
        }
        i++;
    }
    return result;
}