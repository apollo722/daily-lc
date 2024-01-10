/*
https://leetcode.com/problems/tree-diameter/

和543类似，只需要递归找到最大的两支子树即可
注意可能存在没有子节点的节点，即要判断g.get(cur)==0的情况

Time: O(n)
Space: O(n)
*/

class Solution {
    List<List<Integer>> g = new ArrayList<>();
    int res = 0;
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        buildGraph(g, edges);
        calc(0, new boolean[n]);
        return res;
    }

    private int calc(int cur, boolean[] visited) {
        int n = g.get(cur).size();
        if (visited[cur] || n == 0) return 0;
        visited[cur] = true;
        int max1 = 0, max2 = 0;
        for (int next : g.get(cur)) {
            int ans = calc(next, visited);
            if (ans > max1) {
                max2 = max1;
                max1 = ans;
            } else if (ans > max2) {
                max2 = ans;
            }
        }
        res = Math.max(res, max1 + max2);
        return max1 + 1;
    }

    private void buildGraph(List<List<Integer>> g, int[][] edges) {
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
    }
}