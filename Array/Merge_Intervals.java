time complexity: O(n*lgn)
space complexity: o(n)


先排序, 然后对当前的interval判断最多可以包含多少个后续的interval, 并不断的更新该interval. 如果不能包含, 则将新的interval放入结果集, 重复上一步.


public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1)
		return intervals;

	// Sort by ascending starting point
	Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    
    List<int[]> result = new ArrayList<>();
    int[] lastInterval = intervals[0];
    result.add(lastInterval);
    for (int[] interval : intervals) {
        if (interval[0] <= lastInterval[1]) {
            lastInterval[1] = Math.max(lastInterval[1], interval[1]);
        } else {
            lastInterval = interval;
            result.add(lastInterval);
        }
    }
    return result.toArray(new int[result.size()][]);
}