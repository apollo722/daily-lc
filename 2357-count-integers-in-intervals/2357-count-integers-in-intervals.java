class CountIntervals {
    // 使用 TreeMap 来存储区间，key 是区间的左端点，value 是区间的右端点
    TreeMap<Integer, Integer> intervals = new TreeMap<>();
    // 用于记录当前所有区间的覆盖范围
    int totalCovered = 0;

    // 添加一个区间 [left, right]
    public void add(int left, int right) {
        // 找到左端点小于等于 left 的最大区间
        var entry = intervals.floorEntry(left);
        // 如果找到的区间不与新区间重叠（即它的右端点小于 left），则尝试找到左端点大于 left 的最小区间
        if (entry == null || entry.getValue() < left) {
            entry = intervals.higherEntry(left);
        }

        // 遍历所有可能与新区间重叠或相邻的区间，并进行合并
        while (entry != null && entry.getKey() <= right) {
            // 合并区间：更新新区间的范围
            left = Math.min(left, entry.getKey());
            right = Math.max(right, entry.getValue());
            // 从 totalCovered 中减去被合并的旧区间的长度
            totalCovered -= entry.getValue() - entry.getKey() + 1;
            // 从 TreeMap 中移除旧的区间
            intervals.remove(entry.getKey());
            // 继续检查下一个区间
            entry = intervals.higherEntry(left);
        }

        // 将合并后的新区间插入 TreeMap
        intervals.put(left, right);
        // 更新 totalCovered，加上新区间的长度
        totalCovered += right - left + 1;
    }

    // 返回当前所有区间的覆盖范围
    public int count() {
        return totalCovered;
    }
}
