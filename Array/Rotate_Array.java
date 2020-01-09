time complexity: O(n)

swap from 0 ~ n - k - 1
swap from n - k ~ n - 1
swap from 0 ~ n - 1

private void swap(int[] nums, int i, int j) {
    while(i < j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        i++;
        j--;
    }    
}

public void rotate(int[] nums, int k) {
    if (nums == null || nums.length == 0 || k == 0) return ;
    int n = nums.length;
    k %= n;
    swap(nums, 0, n - k - 1);
    swap(nums, n - k, n - 1);
    swap(nums, 0, n - 1);
}