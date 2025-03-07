class MKAverage {
    Deque<Integer> q = new ArrayDeque<>();
    TreeMap<Integer, Integer> treeM = new TreeMap<>();
    int m, k, curSum;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.curSum = 0;
    }
    
    public void addElement(int num) {
        q.add(num);
        treeM.put(num, treeM.getOrDefault(num, 0) + 1);
        curSum += num;
        if (q.size() > m) {
            int remove = q.poll();
            treeM.put(remove, treeM.get(remove) - 1);
            if (treeM.get(remove) == 0) treeM.remove(remove);
            curSum -= remove;
        }
    }
    
    public int calculateMKAverage() {
        if (q.size() < m) return -1;
        int res = curSum, tempK = k;
        for (Map.Entry<Integer, Integer> e : treeM.entrySet()) {
            int v = e.getValue();
            if (v < tempK) {
                res -= e.getKey() * v;
            } else{
                res -= e.getKey() * tempK;
            }
            tempK -= v;
            if (tempK <= 0) break;
        }
        tempK = k;
        int lowestKey = treeM.lastKey();
        while (true) {
            int v = treeM.get(lowestKey);
            if (v < tempK) {
                res -= v * lowestKey;
            } else {
                res -= tempK * lowestKey;
            }
            tempK -= v;
            if (tempK <= 0) break;
            lowestKey = treeM.lowerKey(lowestKey);
        }
        return res / (m - 2 * k);
    }
}


/*
朴素的想，每次计算的时候，都找到最后m个，排序，去掉前k后k，计算均值。
逐步优化上述朴素过程。
1. 每次计算的时候不需要找最后m个，只需要保持有m个就行，反正m个之前的元素再也不会用到了。
2. 如果能保证m个元素一直有序就可以了。什么数据结构能保证元素一直有序还方便增删？treemap。
3. 去掉前后k比较朴素，只要有序了循环前后即可。
4. 计算均值需要总和和个数。个数是固定的m-2k，总数在保持m个元素的时候边加边算，去掉k时边去掉边减就行。
*/