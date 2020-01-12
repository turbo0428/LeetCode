time complexity: O(n)
space complexity: O(1)

思路就是把数组本身当做一个hash, 因为1 ≤ a[i] ≤ n, 所以数组的下标0 ~ n-1 刚好可以用来标记那些数字出现过. 然后最后扫描一边看那些下标大于0. 

public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
        int val = Math.abs(nums[i]);
        if (nums[val - 1] > 0) {
            nums[val - 1] *= -1;
        }
    }
    for (int i = 0; i < nums.length; ++i) {
        if (nums[i] > 0) {
            res.add(i + 1);
        }
    }
    return res;
}