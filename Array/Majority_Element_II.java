time complexity: O(n)
space complexity: O(1)

因为最后结果集里的值在数组中的个数大于n/3, 所以至多存在2个这样的元素, 所以定义n1和n2, c1和c2表示其出现的次数.
如果当前元素等于n1或n2, 更新c1或c2, 如果都不等则c1-1, c2-1. 如果c1==0, 则把当前元素赋给n1, 如果c2 == 0， 则把当前元素赋给n2
最后判断n1和n2在原数组中的个数

public List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums == null || nums.length == 0) return res;
    int len = nums.length;
    int n1 = nums[0];
    int n2 = nums[0];
    int c1, c2;
    c1 = c2 = 0;
    for (int n : nums) {
        if (n1 == n) {
            c1++;
        } else if (n2 == n) {
            c2++;
        } else if (c1 == 0) {
            c1 = 1;
            n1 = n;
        } else if (c2 == 0) {
            c2 = 1;
            n2 = n;
        } else {
            c1--;
            c2--;
        }
    }
    c1 = c2 = 0;
    for (int n : nums) {
        if (n == n1) c1++;
        if (n == n2) c2++;
    }
    Set<Integer> set = new HashSet<>();
    if (c1 > len / 3) set.add(n1);
    if (c2 > len / 3) set.add(n2);
    return new ArrayList<>(set);
}