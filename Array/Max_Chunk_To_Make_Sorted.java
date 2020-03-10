time complexity: O(n)
space complexity: O(1)

检查当前位置的最大值是否等于下标i, 如果等于则res++. 原理就是检查当前扫描到的这个数是否在其应在的位置, 如果不在则向后寻找,直到找到这个位置或者有比它更大的数, 重复这个操作

original: 0, 2, 1, 4, 3, 5, 7, 6
max:      0, 2, 2, 4, 4, 5, 7, 7
sorted:   0, 1, 2, 3, 4, 5, 6, 7
index:    0, 1, 2, 3, 4, 5, 6, 7

The chunks are: 0 | 2, 1 | 4, 3 | 5 | 7, 6

public int maxChunksToSorted(int[] arr) {

    int res = 0;
    int max = 0;
    for (int i = 0; i < arr.length; ++i) {
        max = Math.max(max, arr[i]);
        if (max == i) res++;
    }
    return res;
}