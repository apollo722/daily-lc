/*
https://leetcode.com/problems/critical-connections-in-a-network/

有个算法专门做这种题：Tarjan's algorithm
题目翻译过来就是找到一些边，导致每次去掉这些边的一条，会导致形成两个连通图
也就是需要找到图中链接连通图的“桥”
具体做法就是用dfs，把每个节点标记上时间戳
遍历每一个u的子节点v，更新u的最小可到达时间，意思是有一个最小的时间节点，可以通过一个和u连着的点来访问u
如果一个它的某个子节点的最小可到达时间大于它自己当前的时间戳，证明那个子节点v如果想访问u或者任何它的parent祖先节点，必须要通过u-v
这是因为v在dfs时先行更新过，那么如果有更小的可到达时间说明它早先已经被访问过了（因为它的最小可到达时间小于现在的时刻）
反之说明v只能通过这条边来访问，所以它的最小可到达时间才会晚于当前的时间戳，所以uv是结果之一
如果一个节点已经被访问了，而且这个节点不是直接parent，说明somehow v已经被u的某个祖先访问了
那么访问它的时间戳就可以反过来帮助u来更新最小可到达时间
为啥用Math.min(low[u], timeStamp[v])，不用Math.min(low[u], low[v])？
因为此时此刻关注的是u-v的直接连接，而不是v通过某个其它节点进而连到u的path，所以用low[v]没有办法帮助来判断u-v这条边的情况，因为包含了过多信息

所以到最后整张图会被最小到达时间分割成几个连通的部分，链接这些部分的边就是答案集合，也就是如果一条边的两个节点最小到达时间不一致，这条边就是答案

Time: O(v + e)
Space: O(e)
*/

class Solution {
    List<List<Integer>> g, res;
    int[] timeStamp, low;
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        timeStamp = new int[n];
        low = new int[n];
        time = 0;
        build(n, connections);
        res = new ArrayList<>();
        dfs(0, -1);
        return res;
    }

    private void dfs(int u, int parent) {
        timeStamp[u] = low[u] = ++time;
        for (int v : g.get(u)) {
            if (timeStamp[v] == 0) {
                dfs(v, u);
                low[u] = Math.min(low[v], low[u]);
                if (low[v] > timeStamp[u]) res.add(Arrays.asList(u, v));
            } else if (v != parent) low[u] = Math.min(low[u], timeStamp[v]);
        }
    }

    private void build(int n, List<List<Integer>> edges) {
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (List<Integer> e : edges) {
            int u = e.get(0), v = e.get(1);
            g.get(u).add(v);
            g.get(v).add(u);
        }
    }
}