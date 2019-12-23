time complexity: O(n)
space complexity; O(1)


i, j分别表示头跟尾指针, 每次检查头尾指针的值, 然后取小的值. 然后判断(cur-min)的值是否大于0, cur表示的意思是当前左右边界的最小值, 如果cur-min大于0, 则把diff加入到res里,
然后移动ih或者j, 值小的下标进行移动.


public int trap(int[] height) {
    int i = 0;
    int j = height.length - 1;
    
    int res = 0;
    int cur = 0;
    while(i < j) {
        int min = Math.min(height[i], height[j]);
        if (cur - min > 0) res += (cur - min);
        cur = Math.max(cur, min);
        
        if (height[i] <= height[j]) {
            i++;
        } else {
            j--;
        }
    }
    return res;
}