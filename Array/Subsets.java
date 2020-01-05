time complexity: O(2^n)
space complexity: O(2^n)

[] -> [], [1] -> [], [1], [2], [1,2] -> [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]

public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int i = 0; i < nums.length; ++i) {
        int size = result.size();
        for (int j = 0; j < size; ++j) {
            List<Integer> l = new ArrayList<>(result.get(j));
            l.add(nums[i]);
            result.add(l);
        }
    }
    return result;
}