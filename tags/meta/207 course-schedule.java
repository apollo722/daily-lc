/*
https://leetcode.com/problems/course-schedule/

拓扑排序模板
入度为0的入队列，每次取出一个并更新对应的边以减少入度，并把入度为0的点继续入队列
如果最后上完的课程与总课程数相等，即为有效课程安排

Time: O(n + m)，n为course数，m为关系数
Space: O(n + m)
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int cur = q.poll();
            for (int next : g.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }
        return cnt == numCourses;
    }
}