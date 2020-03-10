time complexity: O(n)
space complexity: O(1)

index从0开始, 然后把当前的值乘以 -1 表示已经访问过, 然后while loop检查下个位置是否大于0, 如果是继续上一步, 如果不是则更新res.

public int arrayNesting(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int res = 1;
    for (int i = 0; i < nums.length; ++i) {
        if (nums[i] < 0 || i == nums[i]) continue;
        int count = 1;
        int j = nums[i];
        nums[i] *= -1;
        while(nums[j] >= 0) {
            count++;
            int next = nums[j];
            nums[j] *= -1;
            j = next;
        }
        res = Math.max(res, count);
    }
    return res;
}