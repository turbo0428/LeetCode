time complexity: O(n)
space complexity: O(1)

找最大值和第二大的值以及最大值的下标
如果最大值比第二大的值大两倍则为true, 否则为false

public int dominantIndex(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int firstNum = -1;
    int secondNum = -1;
    int p1 = -1;
    for (int i = 0; i < nums.length; ++i) {
        if (nums[i] > firstNum) {
            secondNum = firstNum;
            firstNum = nums[i];
            p1 = i;
        } else if (nums[i] > secondNum) {
            secondNum = nums[i];
        }
    }
    if (firstNum >= (secondNum * 2)) return p1;
    return -1;
}