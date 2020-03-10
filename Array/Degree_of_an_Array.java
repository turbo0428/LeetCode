time complexity: O(n)
space complexity: O(n)

用first这个map来记录每个元素第一次出现时的位置, 然后用count计算元素重复出现的次数
如果大于当前最大值, 则计算长度
如果等于当前最大值, 则取较小的长度


public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, Integer> first = new HashMap<>();
    int res = 0;
    int degree = 0;
    for (int i = 0; i < nums.length; ++i) {
        first.putIfAbsent(nums[i], i);
        count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        
        if (count.get(nums[i]) > degree) {
            degree = count.get(nums[i]);
            res = Math.max(res, i - first.get(nums[i]) + 1);
        } else if (count.get(nums[i]) == degree) {
            res = Math.min(res, i - first.get(nums[i]) + 1);
        }
        
    }
    return res;
}