time complexity: O(n)
space complexity: O(n)

v表示当前元素左边的所有乘积, 然后res[i]表示的就是0 ~ i-1 的乘积. 
然后从右往左扫描, v表示的就是当前元素右边的所有乘积

public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int v = 1;
    for (int i = 0; i < n; ++i) {
        res[i] = v;
        v *= nums[i];
    }
    v = nums[n-1];
    for (int i = n - 2; i >= 0; --i) {
        res[i]*= v;
        v *= nums[i];
    }
    return res;
}