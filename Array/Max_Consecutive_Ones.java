time complexity: O(n)
space complexity: O(1)

对每个index对应值为1 count有多少连续的1并更新最后的结果

public int findMaxConsecutiveOnes(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int result = 0;
    int p = 0;
    int i = 0;
    while(i < nums.length) {
        if (nums[i] == 1) {
            p = i;
            while(i < nums.length && nums[i] == 1) {
                i++;
            }
            result = Math.max(result, i - p);
        } else {
            i++;
        }
    }
    return result;
}