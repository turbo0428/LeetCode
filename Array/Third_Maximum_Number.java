time complexity: O(n)

定义三个数表示数组里最大的三个值. 如果当前值比最大值还大, 则更新第二大和第三大的数, 如果当前值比第二大, 更新第三大, 以此类推

public int thirdMax(int[] nums) {
    Integer max1 = null;
    Integer max2 = null;
    Integer max3 = null;
    for (Integer n : nums) {
        if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
        if (max1 == null || n > max1) {
            max3 = max2;
            max2 = max1;
            max1 = n;
        } else if (max2 == null || n > max2) {
            max3 = max2;
            max2 = n;
        } else if (max3 == null || n > max3) {
            max3 = n;
        }
    }
    return max3 == null ? max1 : max3;
}