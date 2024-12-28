/*
https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

剥洋葱，把所有不含苹果的叶节点一点点除去，剩下的图的叶节点就一定都是苹果，剩下的边数乘2就是结果
每去掉一个不含苹果的叶节点，就少一条边，所以剩下的边数就是总边数-去掉节点数
只有一个入度且没有苹果的节点就是每一层需要去掉的节点

Time: O(n)
Space: O(n)
*/

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int[] indegree = new int[n];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            indegree[u]++;
            indegree[v]++;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!hasApple.get(i) && indegree[i] == 1) q.add(i);
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 0) continue;
            cnt++;
            for (int next : g.get(cur)) {
                indegree[next]--;
                if (!hasApple.get(next) && indegree[next] == 1) {
                    q.add(next);
                }
            }
        }
        return (edges.length - cnt) * 2;
    }
}