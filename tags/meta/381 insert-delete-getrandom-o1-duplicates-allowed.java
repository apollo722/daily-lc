/*
https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

允许重复元素和380并没有本质区别，只需要额外的存储来对应元素以及它的idx
这里选择linkedhashset，即可以快速搜索和删除，且还能找到对首的idx

Time: O(1)
Space: O(n)
*/

class RandomizedCollection {
    HashMap<Integer, LinkedHashSet<Integer>> m = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int idx = 0;
    Random rand = new Random();
    public RandomizedCollection() {
        
    }
    
    public boolean insert(int val) {
        if (m.containsKey(val)) {
            m.get(val).add(idx++);
            list.add(val);
            return m.get(val).size() > 1 ? false : true;
        } else {
            m.put(val, new LinkedHashSet<>());
            m.get(val).add(idx++);
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!m.containsKey(val) || m.get(val).isEmpty()) return false;
        int rIdx = m.get(val).iterator().next();
        m.get(val).remove(rIdx);
        int last = list.get(idx - 1);
        list.set(rIdx, last);
        list.remove(idx - 1);
        m.get(last).add(rIdx);
        m.get(last).remove(idx - 1);
        idx--;
        return true;
    }
    
    public int getRandom() {
        int resIdx = rand.nextInt(idx);
        return list.get(resIdx);
    }
}