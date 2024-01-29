/*
https://leetcode.com/problems/parallel-courses/

拓扑排序模板，从终点反推看处理了几层

Time: O(n)
Space: O(n)
*/

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] outdegree = new int[n + 1];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] e : relations) {
            outdegree[e[0]]++;
            g.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (outdegree[i] == 0) q.add(i);
        }
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            while (size-- > 0) {
                int cur = q.poll();
                cnt++;
                for (int next : g.get(cur)) {
                    outdegree[next]--;
                    if (outdegree[next] == 0) q.add(next);
                }
            }
        }
        return cnt == n ? res : -1;
    }
}