用一个map记录以当前index为subarry的最后一个元素, 它前面sum-k是否存在, 存在的话把个数加到res.


suppose we know 
sum[0 ~ i-1] = a,
sum[0 ~ j] = b

we want to know
sum[i ~ j] = k  --> b - a

b - a = k -> b - k = a
所以我们检查sum - k 是否存在.

public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) return 0;
    int n = nums.length;
    Map<Integer, Integer> pre = new HashMap<>();
    pre.put(0, 1);
    int sum = 0;
    int res = 0;
    for (int i = 0; i < n; ++i) {
        sum += nums[i];
        if (pre.containsKey(sum - k)) {
            res += pre.get(sum - k);
        }
        pre.put(sum, pre.getOrDefault(sum, 0) + 1);
    }
    return res;
}