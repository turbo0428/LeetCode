time complexity: O(n)
space complexity: O(1)

如果nums[i-1] > nums[i], 检查nums[i-2]和nums[i]的大小, 如果nums[i-2]大, 则把nums[i]修改成nums[i-1], 否则nums[i-1] 改成nums[i].

public boolean checkPossibility(int[] nums) {
    int cnt = 0;
    for (int i = 1; i < nums.length && cnt <= 1; ++i) {
        if (nums[i-1] > nums[i]) {
            cnt++;
            if (i - 2 < 0 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
            else nums[i] = nums[i-1];
        }
    }
    return cnt <= 1;
}