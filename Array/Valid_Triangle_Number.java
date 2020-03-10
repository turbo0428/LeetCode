time complexity: O(n^2)
space complexity: o(1)

排序之后从后往前扫描, 对每条边i, 扫描 j ~ k, j = 0, k = i-1.
如果nums[j] + nums[k] > nums[i], 则表示j ~ k 区间都可以组成三角形. res += (k-j), 然后k--
如果不能组成则右移j

public static int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int res = 0;
    for (int i = nums.length - 1; i >= 0; --i) {
    	int j = 0;
    	int k = i - 1;
    	while(j < k) {
    		if (nums[j] + nums[k] > nums[i]) {
    			res += (k - j);
    			k--;
    		} else {
    			j++;
    		}
    	}
    }
    return res;
}