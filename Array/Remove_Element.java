time complexity: o(n)
space complexity: o(1)

遍历每个元素, 如果当前元素的值不等于val则赋值, 然后res + 1. 如果相同则skip这个元素


public int removeElement(int[] nums, int val) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    int res = 0;
    for(int i = 0; i < nums.length; ++i) {
        if (nums[i] != val) {
            nums[res] = nums[i];
            res++;
        }
    }
    return res;
}