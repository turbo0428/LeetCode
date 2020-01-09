time complexity: C(9, k)


private void helper(List<List<Integer>> result, List<Integer> nums, int k, int n, int value, int sum) {
    if (sum == n && nums.size() == k) {
        result.add(new ArrayList<>(nums));
        return ;
    }
    if (nums.size() > k) return ;
    for (int i = value; i <= 9; ++i) {
        sum += i;
        nums.add(i);
        helper(result, nums, k, n, i + 1, sum);
        sum -= i;
        nums.remove(nums.size() - 1);
    }
}


public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    helper(result, nums, k, n, 1, 0);
    return result;
}