time complexity: O(n)
space complexity: O(1)

计算每个数模3之后的个数, 用oneCount和twoCount表示, 计算他们的和然后模3, 如果取模之后的值为1, 判断oneCount是否不为0, 如果是则减一, 如果不是则twoCount -= 2。
同理 如果取模之后的值为2, 判断twoCount是否不为0, 如果是则减一, 如果不是则oneCount -= 2.
然后从后往前扫描cnt数组, 如果i%3等于0, 则把数量为cnt[i]的i加到结果中, 如果i%3等于1, 则把数量为Math.min(cnt[i], oneCount)的i加到结果中,
如果i%3等于2, 则把数量为Math.min(cnt[i], twoCount)的i加到结果中


public String largestMultipleOfThree(int[] digits) {
    if (digits == null || digits.length == 0) return "";
    int[] cnt = new int[10];
    for(int i = 0; i < digits.length; ++i) {
        cnt[digits[i]]++;
    }
    
    int oneCount = cnt[1] + cnt[4] + cnt[7];
    int twoCount = cnt[2] + cnt[5] + cnt[8];
    int remainSum = (oneCount + 2 * twoCount) % 3;
    if (remainSum == 1) {
        if (oneCount >= 1) oneCount -=1;
        else twoCount -= 2;
    } else if (remainSum == 2) {
        if (twoCount >= 1) twoCount -= 1;
        else oneCount -= 2;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 9; i >= 0; --i) {
        if (i % 3 == 0) {
            while(cnt[i]-- > 0) {
                sb.append(i);
            }
        } else if (i % 3 == 1) {
            while(cnt[i]-- > 0 && oneCount-- > 0) {
                sb.append(i);
            }
        } else {
            while(cnt[i]-- > 0 && twoCount-- > 0) {
                sb.append(i);
            }
        }
    }
    if (sb.length() > 0 && sb.charAt(0) == '0') return "0";
    return sb.toString();
}
