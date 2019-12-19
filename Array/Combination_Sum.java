time complexity: O(2^n)

穷举加backtrack

public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    helper(candidates, target, result, 0, nums, 0);
    return result;
}


private void helper(int[] candidates, int target, List<List<Integer>> result, int sum, List<Integer> nums, int p) {
    if (sum > target) return ;
    if (sum == target) {
        List<Integer> t = new ArrayList<>(nums);
        result.add(t);
        return ;
    }
    
    for (int i = p; i < candidates.length; ++i) {
        nums.add(candidates[i]);
        helper(candidates, target, result, sum + candidates[i], nums, i);
        nums.remove(nums.size() - 1);
    }
}