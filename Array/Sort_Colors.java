time complexity: O(n)
space complexity: O(1)

双指针

public void sortColors(int[] nums) {
    int redStart = 0;
    int blueEnd = nums.length - 1;
    int i = 0;
    while(i <= blueEnd) {
        if (nums[i] == 0) {
            swap(nums, i, redStart);
            redStart++;
            i++;
        } else if (nums[i] == 1) {
            i++;
        } else if (nums[i] == 2) {
            swap(nums, i, blueEnd);
            blueEnd--;
        }
    }
}

private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}