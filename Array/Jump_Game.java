time complexity: O(n)
space complexity:O(1)

cur为当前最远能跳到的距离, 如果cur >= i, 将cur更新为cur和(i + nums[i])之间的最大值. 最后判断是cur>=n-1

public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) return true;
    int n = nums.length;
    int cur = 0;
    for (int i = 0; i < n; ++i) {
        if (cur >= i) {
            cur = Math.max(cur, i + nums[i]);
        }
    }
    return cur >= n - 1;
}