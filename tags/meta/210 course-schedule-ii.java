/*
https://leetcode.com/problems/course-schedule-ii/

拓扑排序模板

Time: O(v + e)，v为节点数，e为边数
Space: O(v + e)
*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int u = p[0], v = p[1];
            indegree[u]++;
            g.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int cnt = 0, idx = 0;
        int[] res = new int[numCourses];
        while (!q.isEmpty()) {
            cnt++;
            int cur = q.poll();
            res[idx++] = cur;
            for (int next : g.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }
        if (cnt != numCourses) return new int[0];
        return res;
    }
}