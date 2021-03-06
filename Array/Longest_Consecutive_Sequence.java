time complexity: O(n)
space complexity: O(n)

对每个元素, 检查它左边和右边最多能扩展到多少, 然后+1 就是这个元素最长连续序列.
然后更新(n - left)和(n + right)

public int longestConsecutive(int[] nums) {
    int res = 0;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int n : nums) {
        if (!map.containsKey(n)) {
            int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
            int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
            // sum: length of the sequence n is in
            int sum = left + right + 1;
            map.put(n, sum);
        
            // keep track of the max length 
            res = Math.max(res, sum);
        
            // extend the length to the boundary(s)
            // of the sequence
            // will do nothing if n has no neighbors
            map.put(n - left, sum);
            map.put(n + right, sum);
        }
    }
    return res;
}