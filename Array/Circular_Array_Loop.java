暴力
time complexity: O(n^2)
space complexity:O(n^2)

public boolean circularArrayLoop(int[] nums) {
    if (nums == null || nums.length == 0) return false;
    int len = nums.length;
    for (int i = 0; i < nums.length; ++i) {
        Map<Integer, Boolean> hash = new HashMap<>();
        int pos = i;
        while(true) {
            if (hash.containsKey(pos)) {
                if (pos == i && hash.size() > 1) return true;
                else {
                    break;
                }
            }
            hash.put(pos, true);
            int step = nums[pos];
            if (step < 0) {
                step %= len;
                pos = (len + step + pos) % len;
            } else {
                pos = (pos + step) % len;
            }
            if ((step > 0 && nums[pos] < 0) || (step < 0 && nums[pos] > 0)) break;
        }
    }
    return false;
}


快慢指针

private int getIndex(int i, int[] nums) {
    int n = nums.length;
    int tmp = nums[i] % n;
    return (i + tmp) >= 0 ? (i + tmp) % n : (n + (i + tmp)) % n;
}

public boolean circularArrayLoop(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < nums.length; ++i) {
        if (nums[i] == 0) continue;
        int j = i;
        int k = getIndex(i, nums);
        while(nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
            if (j == k) {
                if (j == getIndex(j, nums)) break;
                return true;
            }
            j = getIndex(j, nums);
            k = getIndex(getIndex(k, nums), nums);
        }
        j = i;
        int val = nums[i];
        while(nums[j] * val > 0) {
            int tmp = getIndex(j, nums);
            nums[j] = 0;
            j = tmp;
        }
    }
    return false;
}