time complexity: o(n)
space complexity: o(1)


从右往左找到第一个破坏升序条件的元素下标p, 如果为-1则swap整个数组. 然后从右往左扫描, 找到第一个数值大于位置p的下标i, 交换i和p位子上的元素, 然后swap p+1到数组结尾的所有元素

public void nextPermutation(int[] nums) {
    if (nums == null || nums.length == 0) return ;
    int p = -1;
    
    // find the first position that breaks the ascending
    for(int i = nums.length - 1; i > 0; --i) {
        if (nums[i] > nums[i-1]) {
            p = i - 1;
            break;
        }
    }        
    if (p == -1) {
        // swap the entire array
        reverse(nums, 0);
    } else {
        // find the position that the value larger than that of at position p
        int i = -1;
        for (int j = nums.length - 1; j >= 0; --j) {
            if (nums[j] > nums[p]) {
                i = j;
                break;
            }
        }
        swap(nums, i, p);
        reverse(nums, p + 1);
    }
}

private void reverse(int[] nums, int start) {
    int i = start, j = nums.length - 1;
    while (i < j) {
        swap(nums, i, j);
        i++;
        j--;
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}