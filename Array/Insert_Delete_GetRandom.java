time complexity: O(1)
space complexity: O(n)

用一个list存所有的val, 用一个map记录(val, pos), pos是list的index, remove的时候检查当前val是不是list的最后一个元素， 如果是则删除list的最后一个元素, 删除
map里对应的key-value pair. 如果不是, 则把最后一个元素换到当前要删除元素的位置,再重复刚才那一步


class RandomizedSet {

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        hash = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hash.containsKey(val)) return false;
        hash.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hash.containsKey(val)) return false;
        int valPosition = hash.get(val);
        if (valPosition != nums.size() - 1) {
            int lastValue = nums.get(nums.size() - 1);
            hash.put(lastValue, valPosition);
            nums.set(valPosition, lastValue);
        }
        hash.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int p = random.nextInt(nums.size());
        return nums.get(p);
    }
    
    List<Integer> nums;
    Map<Integer, Integer> hash;
}