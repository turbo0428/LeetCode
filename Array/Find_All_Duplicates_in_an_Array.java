time complexity: O(n)
space complexity: O(1)

把数组的index当做hash, 每个元素对应的位置的值乘以-1. 如果扫描过程中发现该值对应的位置已经为负数则表示重复出现了, 加入最后的结果集

public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
        int value = Math.abs(nums[i]);
        if (nums[value - 1] > 0) {
            nums[value - 1] *= -1;
        } else {
            res.add(value);
        }
    }
    return res;
}