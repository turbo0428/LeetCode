



public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < tasks.length; ++i) {
        map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
    }
    
    PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(
        (a, b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
    
    q.addAll(map.entrySet());
    int res = 0;
    while(!q.isEmpty()) {
        int k = n + 1;
        List<Map.Entry<Character, Integer>> tmp = new ArrayList<>();
        while(k > 0 && !q.isEmpty()) {
            Map.Entry<Character,Integer> top = q.poll();
            top.setValue(top.getValue() - 1);
            tmp.add(top);
            k--;
            res++;
        }
        for (Map.Entry<Character, Integer> entry : tmp) {
            if (entry.getValue() > 0) q.add(entry);
        }
        if (q.isEmpty()) break;
        res += k;
    }
    return res;
}