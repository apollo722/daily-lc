/*
https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

将频率排序从小到大移除即可
也可以用桶排序按照频率排，这样时间复杂度做到O(n)

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : arr) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }
        int cnt = 0;
        while (k > 0 && !pq.isEmpty()) {
            int cur = pq.poll()[1];
            if (cur > k) return m.size() - cnt;
            k -= cur;
            cnt++;
        }
        return m.size() - cnt;
    }
}