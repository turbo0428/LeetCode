类似 combinationSum


public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    helper(candidates, target, result, tmp, 0, 0);
    return result;
}

private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> tmp, int sum, int pos) {
    if (sum > target) return ;
    if (sum == target) {
        List<Integer> l = new ArrayList<>(tmp);
        result.add(l);
        return ;
    }
    for (int i = pos; i < candidates.length; ++i) {
        tmp.add(candidates[i]);
        helper(candidates, target, result, tmp, sum + candidates[i], i + 1);
        tmp.remove(tmp.size() - 1);
        while(i < candidates.length - 1 && candidates[i] == candidates[i+1]) {
            i++;
        }
    }
}