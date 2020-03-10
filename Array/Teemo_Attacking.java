time complexity: O(n)
space complexity: O(1)

如果当前元素的值小于等于最后一次攻击持续的时间范围内, 则加上 timeSeries[i] + duration - 1 - lastTime, 否则加上 duration即可.
每次更新当前元素攻击的范围(lastTime)

public int findPoisonedDuration(int[] timeSeries, int duration) {
    int res = 0;
    int lastTime = -1;
    for (int i = 0; i < timeSeries.length; ++i) {
        if (timeSeries[i] <= lastTime) {
            res += (timeSeries[i] + duration - 1 - lastTime);
        } else {
            res += duration;
        }
        lastTime = timeSeries[i] + duration - 1;
    }
    return res;
}