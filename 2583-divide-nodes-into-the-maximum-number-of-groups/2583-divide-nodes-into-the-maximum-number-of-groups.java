class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        HashMap<Integer, Integer> component = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] depth = new int[n];
            int componentId = n + 1, groupCnt = 0;
            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{i, 1});
            depth[i] = 1;
            while (!q.isEmpty()) {
                int[] curPair = q.poll();
                int cur = curPair[0], d = curPair[1];
                groupCnt = Math.max(groupCnt, d);
                componentId = Math.min(componentId, cur);
                for (int next : g.get(cur)) {
                    if (depth[next] == d) return -1;
                    if (depth[next] == 0) {
                        depth[next] = d + 1;
                        q.add(new int[]{next, d + 1});
                    }
                }
            }
            if (component.getOrDefault(componentId, 0) < groupCnt) {
                component.put(componentId, groupCnt);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : component.entrySet()) {
            res += e.getValue();
        }
        return res;
    }
}


/*
这道题一上来的思路要联想到二分图（bipartite graph），因为任何相连的两个节点不能在同一组，定义符合二分图。
也就是说，只有满足二分图的输入才能有答案，否则一定是-1。
再往下想，二分图可以堆在一起，即一个节点的父和子level都可以在一个组，涂色嘛，两种颜色就够了。
而题目要求越多颜色越好。那就意味着应该尽可能的每次遇到一个新的level就涂一个新的颜色。
而在这个过程中，如果遇到不满足二分的，即之前图过的色和当前父节点的颜色一样，即直接退出，因为不能二分。
如果题目的图是连通的，这么做已经可以找到答案了，即能涂多少颜色就有多少group。
然而本题可能有多个子图，所以每一个子图都要检查一遍。最笨的方法就是先dfs或者union find把连通图都找出来，逐个算。
更高效一点的办法就是逐个节点去算，算的时候选一个该子图的代表，比如idx最小的节点。
之后在计算该图的过程中更新最小的idx代表和能涂的最多的颜色，并把它们放到map中。
最后的结果就是map里面所有子图group的和。
*/