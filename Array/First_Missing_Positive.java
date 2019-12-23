time complexity: O(n)
space complexity: O(1)


1. 
先把所有value<=0 的元素设置为len + 1, 然后对每个位置上的值取绝对值得到value, 然后检查nums[value-1]是不是大于0, 如果大于则表示没有出现过, 然后乘以-1, 
如果nums[value-1] < 0则表示元素重复了, ignore it.

2.
重置所有元素的位置


public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) return 1;
    int n = nums.length;
    for (int i = 0; i < n; ++i) {
        if (nums[i] <= 0) nums[i] = n + 1;
    }
    for(int i = 0; i < n; ++i) {
        int value = Math.abs(nums[i]);
        if (value > n) continue;
        if (nums[value - 1] > 0) {
            nums[value - 1] *= -1;
        }
    }
    int res = -1;
    for (int i = 0; i < n; ++i) {
        if (nums[i] > 0) {
            res = i;
            break;
        }
    }
    if (res == -1) return n + 1;
    return res + 1;
}



int firstMissingPositive(int A[], int n)
{
    for(int i = 0; i < n; ++ i)
        while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
            swap(A[i], A[A[i] - 1]);
    
    for(int i = 0; i < n; ++ i)
        if(A[i] != i + 1)
            return i + 1;
    
    return n + 1;
}