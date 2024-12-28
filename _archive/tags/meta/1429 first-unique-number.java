/*
https://leetcode.com/problems/first-unique-number/

用map来存储频率，每次搜索都看一下是否频率是1，否则继续往下走即可
每个idx只会被搜索到1次，所以查询avg O(1)
也可以用double linkedlist来做，用map存储val到node的映射
非重复节点加到list尾部，重复的话从list中remove
每次返回list头部即可，如果头部等于尾部，返回-1

Time: O(n), O(1), O(1) avg
Space: O(n)
*/

class FirstUnique {
    List<Integer> q = new ArrayList<>();
    HashMap<Integer, Integer> m = new HashMap<>();
    int idx = 0;

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            q.add(num);
        }    
    }
    
    public int showFirstUnique() {
        while (idx < q.size()) {
            int curNum = q.get(idx);
            if (m.get(curNum) == 1) return curNum;
            else idx++;
        }    
        return -1;
    }
    
    public void add(int value) {
        m.put(value, m.getOrDefault(value, 0) + 1);
        q.add(value);
    }
}