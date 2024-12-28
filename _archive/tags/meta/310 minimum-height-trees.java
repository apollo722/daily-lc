/*
https://leetcode.com/problems/minimum-height-trees/

拓扑排序模板，剥洋葱
从只有1个入度的节点开始向内走
如果最后只剩下2个节点或1个节点，那么q中剩下的节点即为答案

Time: O(n)，n个node最多有n-1条边，所以不管是构建图还是找叶节点，都不会超过n
Space: O(n)，邻接表最多占用n+n-1的空间
*/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n <= 2) {
            for (int i = 0; i < n; i++) res.add(i);
            return res;
        }
        int[] indegree = new int[n];
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.get(u).add(v);
            g.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.add(i);
                visited[i] = true;
            }
        }
        while (n > 2) {
            int size = q.size();
            while (size-- > 0) {
                n--;
                int cur = q.poll();
                for (int next : g.get(cur)) {
                    if (visited[next]) continue;
                    indegree[next]--;
                    if (indegree[next] == 1) q.add(next);
                }
            }
        }
        while (!q.isEmpty()) res.add(q.poll());
        return res;
    }
}