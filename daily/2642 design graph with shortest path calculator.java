/*
https://leetcode.com/problems/design-graph-with-shortest-path-calculator/

Dijkstra算法
从起点开始，将所有邻居放到pq，逐个更新最短距离

Time: O(n + m(v + elogv))，n为addEdge call，m为shortestPath call
建图：O(e + v)
addEdge：O(n)
shortestPath：O(v + elogv)

Space: O(n + e + v)
建图：O(e + v)
addEdge：O(n)
shortestPath：O(e + v)
*/

class Graph {
    List<List<int[]>> g;
    int n;
    public Graph(int n, int[][] edges) {
        this.n = n;
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(new int[]{e[1], e[2]});
        }
    }
    
    public void addEdge(int[] edge) {
        g.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[node1] = 0;
        pq.offer(new int[]{node1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], c = cur[1];
            if (u == node2) return c;
            for (int[] e : g.get(u)) {
                int v = e[0], nextC = e[1];
                if (nextC + c < cost[v]) {
                    cost[v] = nextC + c;
                    pq.offer(new int[]{v, nextC + c});
                }
            }
        }
        return -1;
    }
}