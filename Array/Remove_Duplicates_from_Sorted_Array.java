time complexity: O(n)
sapce complexity: O(1)

如果数组非空则必然存在一个数, 所以res初始化为1, 然后判断每个index的值是否等于(res - 1)位置上的值, 
如果相等则接着往后走, 如果不等则把这个值赋给nums[res], 然后更新res的值.

public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int res = 1;
    for(int i = 1; i < nums.length; ++i) {
        if (nums[i] != nums[res-1]) {
            nums[res] = nums[i];
            res++;
        }
    }
    return res;
}