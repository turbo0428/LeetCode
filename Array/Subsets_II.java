time complexity: O(2^n)
space complexity: O(2^n)

考虑重复值的情况, 只需要记录上一次做了多少次操作即可, 


public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    Arrays.sort(nums);
    int count = 0;
    int t = 0;
    for (int i = 0; i < nums.length; ++i) {
        int len = result.size();
        if (i > 0 && nums[i-1] == nums[i]) {
            count = t;
        } else {
            count = len;
        }
        t = 0;
        for (int j = len - 1; j >= 0 && count > 0; --j, --count) {
            List<Integer> l = new ArrayList<>(result.get(j));
            l.add(nums[i]);
            result.add(l);
            t++;
        }
    }
    return result;
    
}