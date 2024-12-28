/*
https://leetcode.com/problems/finding-mk-average/

保持一个Queue和TreeMap，每次add都分别加入Queue和TreeMap，并计算curSum
Queue中多余m个元素时，也对应移除队列前端元素，并从map中移除，更新curSum

当需要计算平均数时，分别从map的头部和尾部找到k个元素，并从curSum中减去即可

Time: O(logm) add，O(klogm) calculate
Space: O(m)
*/

class MKAverage {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    Queue<Integer> q = new LinkedList<>();
    int curSum = 0;
    int m;
    int k;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }
    
    public void addElement(int num) {
        q.add(num);
        curSum += num;
        if (q.size() > m) {
            int remove = q.poll();
            curSum -= remove;
            if (num == remove) return;
            treeMap.put(remove, treeMap.get(remove) - 1);
            if (treeMap.get(remove) == 0) treeMap.remove(remove);
        }  
        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
    }
    
    public int calculateMKAverage() {
        if (q.size() < m) return -1;
        int res = curSum;
        int tmpK = k;
        for (Map.Entry<Integer, Integer> e : treeMap.entrySet()) {
            int v = e.getValue();
            if (tmpK > v) {
                res -= v * e.getKey();
                tmpK -= v;
            } else {    
                res -= tmpK * e.getKey();
                tmpK -= v;
            }
            if (tmpK <= 0) break;
        }
        tmpK = k;
        int curKey = treeMap.lastKey();
        while (true) {
            int v = treeMap.get(curKey);
            if (tmpK > v) {
                res -= v * curKey;
                tmpK -= v;
            } else {    
                res -= tmpK * curKey;
                tmpK -= v;
            }
            if (tmpK <= 0) break;
            curKey = treeMap.lowerKey(curKey);
        }

        return res / (m - 2 * k);
    }
}