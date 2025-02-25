class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : dislikes) {
            int u = e[0], v = e[1];
            g.get(u - 1).add(v - 1);
            g.get(v - 1).add(u - 1);
        }

        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, -1, g, visited)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, int color, List<List<Integer>> g, int[] visited) {
        visited[cur] = color;
        for (int next : g.get(cur)) {
            if (visited[next] == color) return false;
            if (visited[next] == 0) {
                if (!dfs(next, -1 * color, g, visited)) return false;
            }
        }
        return true;
    }
}


/*
二分图（bipartition/bipartite）问题。
不同于801的解法，也可以用DFS来解。
即遍历每一个没遍历过的节点，给它着色。之后看它的所有邻居是否与它颜色相同。
如果相同，即不符合二分图定义。否则给它着色成相反的颜色并继续。
*/