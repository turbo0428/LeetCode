time complexity: O(n)


用start表示起始值, len表示最长连续, 直到一个元素 nums[i] - start != len, 把start ~ start + len - 1 放入最后的结果, 
最后遍历结束后把start ~ start + len - 1加到最后的结果

private String helper(int start, int end) {
    if (start == end) {
        return Integer.toString(start);
    }
    
    return Integer.toString(start) + "->" + Integer.toString(end);
}

public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums == null || nums.length == 0) return result;
    int start = nums[0];
    int len = 1;
    for (int i = 1; i < nums.length; ++i) {
        if (nums[i] - start != len) {
            result.add(helper(start, start + len - 1));
            start = nums[i];
            len = 1;
        } else {
            len++;
        }
    }
    result.add(helper(start, start + len - 1));
    return result;
}