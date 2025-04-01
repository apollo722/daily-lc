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