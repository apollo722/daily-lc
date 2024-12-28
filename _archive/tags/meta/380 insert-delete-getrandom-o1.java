/*
https://leetcode.com/problems/insert-delete-getrandom-o1/

用list来存储数字，同时用map来存储数字对应的idx
插入时，直接插入list并更新map
随机时，直接随机出一个idx并返回
删除时，先找到需要删除数字的下标，之后将list中最后一个数字与要删除的数字替换
更新map中原来最后一个数字的下标，之后删除最后一个数字，并也在map中将其删除

Time: O(1)，最坏情况是当arraylist需要allocate更多空间时要复制整个数组
Space: O(n)
*/

class RandomizedSet {
    List<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> m = new HashMap<>();
    Random rand = new Random();
    int size = 0;
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (m.containsKey(val)) return false;
        m.put(val, size++);
        list.add(val);
        return true;
    }   
    
    public boolean remove(int val) {
        if (!m.containsKey(val)) return false;
        int idx = m.get(val);
        list.set(idx, list.get(size - 1));
        m.put(list.get(size - 1), idx);
        m.remove(val);
        list.remove(size - 1);
        size--;
        return true;
    }
    
    public int getRandom() {
        int idx = rand.nextInt(size);
        return list.get(idx);
    }
}