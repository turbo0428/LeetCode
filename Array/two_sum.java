time complexity: O(N)
space complexity: O(N)

对当前扫描到的元素进行检查, 如果(target - nums[i])存在于map中, 则返回结果. 如果不存在, 则把(value, position)存入map.

public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
        int remaining = target - nums[i];
        if (map.containsKey(remaining)) {
            result[0] = map.get(remaining);
            result[1] = i;
            break;
        }
        map.put(nums[i], i);
    }
    return result;
}