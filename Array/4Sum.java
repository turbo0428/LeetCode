time complexity: O(n^3)

public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int i = 0;
    while(i + 3 < nums.length) {
        int j = i + 1;
        while(j + 2 < nums.length) {
            int m = j + 1;
            int n = nums.length - 1;
            while(m < n) {
                int cur = nums[i] + nums[j] + nums[m] + nums[n];
                if (cur == target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[m]);
                    res.add(nums[n]);
                    result.add(res);
                    while(m < n && nums[m] == nums[m+1]) {
                        m++;
                    }
                    while(m < n && nums[n-1] == nums[n]) {
                        n--;
                    }
                    m++;
                    n--;
                } else if (cur > target) {
                    n--;
                } else {
                    m++;
                }
            }
            while(j < nums.length - 1 && nums[j] == nums[j+1]) {
                j++;
            }
            j++;
        }
        while(i < nums.length - 1 && nums[i] == nums[i+1]) {
            i++;
        }
        i++;
    }
    return result;
}