/*
https://leetcode.com/problems/car-pooling/

按照时间排序，统计每个时间点上下车的人数
如果任何时间点的乘客数大于容量即返回false
此题时间点有限，也可以用bucket sort

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> t = new TreeMap<>();
        for (int[] trip : trips) {
            int start = t.getOrDefault(trip[1], 0) + trip[0];
            t.put(trip[0], start);
            int end = t.getOrDefault(trip[2], 0) - trip[2];
            t.put(trip[2], end);
        }
        int sum = 0;
        for (int cur : t.values()) {
            sum += cur;
            if (sum > capacity) return false;
        }
        return true;
    }
}