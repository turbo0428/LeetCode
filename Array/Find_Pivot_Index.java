time complexity: O(n)
space complexity: O(1)

先求数组的和total, 然后用sum记录从0开始到i-1的所有和, 然后对每个位置i检查total - nums[i] 是否等于sum*2. 如果等于则表示i位置是pivot

public int pivotIndex(int[] nums) {
    int len = nums.length;
    int sum = 0;
    int total = 0;
    for (int num : nums) total += num;
    for (int i = 0; i < nums.length; sum += nums[i++]) {
        if (sum * 2 == total - nums[i]) return i;
    }
    return -1;
}