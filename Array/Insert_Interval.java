time complexity: O(n)
space complexity: O(n)

遍历intervals, 把左侧不相交的interval全部加入结果集, 然后更新newInterval使得其包含最多的interval, 最后把剩余的interval加入结果集

public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null) return intervals;
    List<int[]> result = new ArrayList<>();
    int len = intervals.length;
    int i = 0;
    // 左侧不相交
    while(i < len && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i]);
        i++;
    }

    while(i < len && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }

    result.add(newInterval);

    while(i < len) {
        result.add(intervals[i]);
        i++;
    }

    return result.toArray(new int[result.size()][]);
}