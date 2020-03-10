time complexity: O(n)
space complexity: O(1)

如果遇到1则p + 2, 否则p++. 判断最后p的值是否等于bits.length - 1

public boolean isOneBitCharacter(int[] bits) {
    if (bits == null || bits.length == 0) return false;
    int p = 0;
    while(p < bits.length - 1) {
        if (bits[p] == 0) {
            p++;
        } else {
            p += 2;
        }
    }
    return p == bits.length - 1;
}