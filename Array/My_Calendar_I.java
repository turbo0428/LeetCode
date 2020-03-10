time complexity: O(n*lgn)
space complexity;O(n)

找小于等于start的最大的区间 floor
找大于等于start的最小区间 ceiling

如果floor的第二个值比start大 则表示start位于区间内, 返回false
如果ceiling的第一个值比end小, 则表示end位于区间内, 返回false

否则返回true

class MyCalendar {

    TreeMap<Integer, Integer> tMap = new TreeMap<>();
    public MyCalendar() {
    }
    
    public boolean book(int start, int end) {
        
        Map.Entry<Integer, Integer> floor = tMap.floorEntry(start);
        Map.Entry<Integer, Integer> ceiling = tMap.ceilingEntry(start);
        if (floor != null && floor.getValue() > start) return false;
        if (ceiling != null && ceiling.getKey() < end) return false;
        tMap.put(start, end);
        return true;
    }
}