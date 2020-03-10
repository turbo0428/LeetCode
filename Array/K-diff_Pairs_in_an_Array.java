time complexity: O(n)
space complexity: O(n)

初始想法: 用map记录元素以及出现的个数, 用set记录已经访问过的元素, 如果该元素没有被访问过, 判断nums[i] + k 和 nums[i] - k, 如果存在于map, 则res++, 如果k==0, 则判断
元素个数是否大于1. 最后输出结果的时候判断k是否为0，如果为0， 则返回res， 否则返回res/2, 因为被重复了2遍

public int findPairs(int[] nums, int k) {
	if (k < 0)
		return 0;
	Map<Integer, Integer> hash = new HashMap<>();
	Set<Integer> visited = new HashSet<>();
	int res = 0;
	for (int i = 0; i < nums.length; ++i) {
		hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
	}

	for (int i = 0; i < nums.length; ++i) {
		if (visited.contains(nums[i])) continue;
		int n1 = nums[i] + k;
		int n2 = nums[i] - k;

		if (k == 0) {
			if (hash.containsKey(nums[i]) && hash.get(nums[i]) > 1) {
				res++;
			}
		} else {
			if (hash.containsKey(n1)) {
				res++;
			}
			if (hash.containsKey(n2)) {
				res++;
			}
		}
		visited.add(nums[i]);
	}
    return k == 0 ? res : res / 2; 
}


改进
public int findPairs(int[] nums, int k) {
    if (k < 0) {
        return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int i : nums) {
        if (map.containsKey(i)) {
            if (k == 0 && map.get(i) == 1) {
                result++;
            }
            map.put(i, map.get(i) + 1);
        } else {
            if (map.containsKey(i - k)) {
                result++;
            }
            if (map.containsKey(i + k)) {
                result++;
            }
            map.put(i, 1);
        }
    }
    return result;
}