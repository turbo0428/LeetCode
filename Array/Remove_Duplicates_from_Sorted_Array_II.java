time complexity: O(n)
space complexity: O(1)

public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int res = 1;
    boolean flag = false;
    for (int i = 1; i < nums.length; ++i) {
        if (nums[i] == nums[res-1]) {
            if (flag) continue;
            nums[res] = nums[i];
            res++;
            flag = true;
        } else {
            flag = false;
            nums[res] = nums[i];
            res++;
        }
    }
    return res;
}

改进版

public int removeDuplicates(int[] nums) {
   int i = 0;
   for (int n : nums)
      if (i < 2 || n > nums[i - 2])
         nums[i++] = n;
   return i;
}