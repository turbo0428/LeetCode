time comlexity: O(n^2)
space comlexity: O(1)

从倒数第二排开始, i from 0 to size of the current row, 然后取当前这排下面那一排i和i+1位置上值小的元素加到当前这排位置为i的元素上
int value = cur.get(j) + Math.min(next.get(j), next.get(j+1));

public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    for (int i = n - 2; i >= 0; --i) {
        List<Integer> cur = triangle.get(i);
        List<Integer> next = triangle.get(i+1);
        for (int j = 0; j < cur.size(); ++j) {
            int value = cur.get(j) + Math.min(next.get(j), next.get(j+1));
            cur.set(j, value);
        }
    }
    return triangle.get(0).get(0);
}