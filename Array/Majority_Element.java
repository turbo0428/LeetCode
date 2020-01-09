time complexity: O(N)

因为最后的结果 个数大于n/2, 所以用一个count来计数, 如果和当前值相等则count+1, 否则count - 1. 如果count等于0, 则更新count = 1, 并把当前值赋值为最后的结果.

public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int n = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; ++i) {
        if (nums[i] == n) {
            count++;
        } else {
            count--;
            if (count == 0) {
                count = 1;
                n = nums[i];
            }
        }
    }
    return n;
}