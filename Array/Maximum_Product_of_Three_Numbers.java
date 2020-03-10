time complexity: O(n*lgn)
space complexity: O(1)

排序, 然后找最小的两个数, 和最大的三个数.
然后比较最小的两个数和最大的数的乘积, 和最大三个数的乘积.

可以不用排序. 

public int maximumProduct(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    Arrays.sort(nums);
    int len = nums.length;
    int n1 = nums[0];
    int n2 = nums[1];
    int p1 = nums[len - 1];
    int p2 = nums[len - 2];
    int p3 = nums[len - 3];
    
    int v1 = n1 * n2 * p1;
    int v2 = p1 * p2 * p3;
    return v1 > v2 ? v1 : v2;
}


public int maximumProduct(int[] nums) {
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    for (int n : nums) {
        if (n > max1) {
            max3 = max2;
            max2 = max1;
            max1 = n;
        } else if (n > max2) {
            max3 = max2;
            max2 = n;
        } else if (n > max3) {
            max3 = n;
        }

        if (n < min1) {
            min2 = min1;
            min1 = n;
        } else if (n < min2) {
            min2 = n;
        }
    }
    return Math.max(max1*max2*max3, max1*min1*min2);
}