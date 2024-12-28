/*
https://leetcode.com/problems/detonate-the-maximum-bombs/

构建图，将所有可以连炸的node放到邻接表中
将每一个点作为起点，用BFS/DFS查找最多可以连接几个节点

union find不work是因为a引爆b，c也引爆b，但不代表a通过b可以引爆c
union find的链接是无向的，此题的链接是有向的

Time: O(n3)
Space: O(n2)
*/

class Solution {
    HashMap<Integer, List<Integer>> g = new HashMap<>();
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                int x2 = bombs[j][0], y2 = bombs[j][1];
                if (!g.containsKey(i)) g.put(i, new ArrayList<>());
                if ((long) r1 * r1 >= (long)(x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2)) {
                    g.get(i).add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, bfs(i));
        }
        return res;
    }

    private int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> nextList = g.get(cur);
            if (nextList == null) continue;
            for (int next : nextList) {
                if (!visited.contains(next)) {
                    q.add(next);
                    visited.add(next);
                }
            }
        }
        return visited.size();
    }
}