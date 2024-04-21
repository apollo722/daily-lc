/*
https://leetcode.com/problems/find-if-path-exists-in-graph/

传统图题
DFS/BFS/union-find均可

Time: O(e + v)
Space: O(e + v) 
*/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : g.get(cur)) {
                if (next == destination) return true;
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }
}