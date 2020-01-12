time complexity: O(l*lgn)

找 1 ~ n-1 的中值, 然后count数组中多少值小于这个中值, 如果count的值大于mid 则表示重复的值在1 ~ mid之间, 反之则在mid + 1 ~ n - 1

public int findDuplicate(int[] nums) {
    if (nums == null || nums.length <= 1) return 0;
    int l = 1;
    int r = nums.length - 1;
    while(l < r) {
        int mid = l + (r - l) / 2;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= mid) {
                count++;
            }
        }
        if (count > mid) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    return l;
}


O(n)

https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.