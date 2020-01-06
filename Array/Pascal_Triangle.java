time complexity: O(n^2)
space complexity: O(n^2)

public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) return result;
    List<Integer> row = new ArrayList<>();
    for (int i = 0; i < numRows; ++i) {
        row.add(0, 1);
        for (int j = 1; j < row.size() - 1; ++j) {
            row.set(j, row.get(j) + row.get(j+1));
        }
        result.add(new ArrayList<>(row));
    }
    return result;
}