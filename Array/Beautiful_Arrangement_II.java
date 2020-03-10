time complexity: O(n)
space complexity: O(n)

分k为奇数和偶数讨论,

如果为奇数, 前k-1个数为, 1, N - 1, 2, N - 2, 3, 4, 5.....
如果为偶数, 前k-1个数为, 1, N - 1, 2, N - 2, N - 3, N - 4, N - 5.....


public int[] constructArray(int n, int k) {
    int[] res = new int[n];
    res[0] = 1;
    int next = 2;
    int last = n;
    int tmp = k;
    for (int i = 1; i < n; ++i) {
        if (tmp > 1) {
            if (i % 2 == 1) {
                res[i] = last;
                last--;
            } else {
                res[i] = next;
                next++;
            }
            tmp--;
        } else {
            break;
        }
    }
    int times = n - k;
    if (k % 2 == 1) {
        while(times > 0) {
            res[k++] = next++;
            times--;
        }
    } else {
        while(times > 0) {
            res[k++] = last--;
            times--;
        }
    }
    return res;
}

clean code

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        return res;
    }