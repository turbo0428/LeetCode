time complexity: O(n^2)

先对数组排序, 然后用三个指针 i, j, k 分别指向idx, idx + 1 和 length - 1, 然后判断 nums[i]+nums[j]+nums[k] 是否等于0, 如果等于0则放入结果集, 然后对每个下标去重. 

public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int i = 0;
    while(i + 2 < nums.length) {
        int j = i + 1;
        int k = nums.length - 1;
        while(j < k) {
            int total = nums[i] + nums[j] + nums[k];
            if (total == 0) {
                List<Integer> res = new ArrayList<>();
                res.add(nums[i]);
                res.add(nums[j]);
                res.add(nums[k]);
                result.add(res);
                while(j < k && nums[j] == nums[j+1]) {
                    j++;
                }
                while(j < k && nums[k] == nums[k-1]) {
                    k--;
                }
                j++;
                k--;
            } else if (total > 0) {
                k--;
            } else {
                j++;
            }
        }
        while(i < nums.length - 1 && nums[i] == nums[i+1]) {
            i++;
        }
        i++;
    }
    return result;
}