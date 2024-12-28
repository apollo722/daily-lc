/*
https://leetcode.com/problems/range-module/

如果能构建一个如下的数据结构

|______| |____| |_________|

当每次插入，删除，或者查找时，只需要看其边界是否被cover即可

|______| |____| |_________|   
    |______________|

通过treemap来存储range的起点和终点
每次插入或删除，先找到小于range起点和终点的最大数值，然后看找到的终点是否和range有overlap
清除对应的区间并插入新的区间
任何插入和删除操作都保持上述结构
查询时如果range被同一段覆盖，即为true

Time: O(logn + m)，插入和删除的时候，需要logn（n为目前range数）来查找，并且m次操作来删除（m为需要删除的range数，通过iterator），查询只需要O(logn)
Space: O(n)
*/

class RangeModule {
    TreeMap<Integer, Integer> m = new TreeMap<>();

    public RangeModule() {
        
    }
    
    public void addRange(int left, int right) {
        Map.Entry<Integer, Integer> start = m.floorEntry(left), end = m.floorEntry(right);
        if (start != null && start.getValue() >= left) left = start.getKey();
        if (end != null && end.getValue() > right) right = end.getValue();
        m.subMap(left, right).clear();
        m.put(left, right);     
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> start = m.floorEntry(left);
        if (start != null && start.getValue() >= right) return true;
        return false;
    }
    
    public void removeRange(int left, int right) {
        Map.Entry<Integer, Integer> start = m.floorEntry(left), end = m.floorEntry(right);
        if (start != null && start.getValue() > left) m.put(start.getKey(), left);
        if (end != null && end.getValue() > right) m.put(right, end.getValue());
        m.subMap(left, right).clear();
    }
}