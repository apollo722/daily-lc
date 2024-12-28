/*
https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

如果是求最小时间的路径，那么就是Dijkstra算法，所以一个思路是先用Dijkstra求出0到每个节点的最短时间
之后反向DFS求出路径数
求路径数的时候只有当前节点是最短路径的时候才需要计算，这是因为如果当前路径更短，会有更短的总路径，显然不可能
而如果当前路径耗时更久，那么余下的路径想追回来也不可能了，所以每个节点的时间需要时exactly最短的才可以

另一种二合一的思路就是边找最短距离边计算
如果找到了更短的路径，当前的路径数会被继承到下一个节点
如果当下个节点耗时刚好等于最短的耗时，那么当前的路径数是可以累加上的

Time: O(elogv)
Space: O(e+v)
*/

class Solution {
    class Node {
        int id;
        long time;

        Node(int id, long time) {
            this.id = id;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Node>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            g.get(r[0]).add(new Node(r[1], r[2]));
            g.get(r[1]).add(new Node(r[0], r[2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        long[] dist = new long[n];
        int[] res = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE / 2);
        res[0] = 1;

        pq.offer(new Node(0, 0));

        int mod = (int) 1e9 + 7;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int id = cur.id;
            long time = cur.time;

            for (Node next : g.get(id)) {
                int nextId = next.id;
                long nextTime = next.time;

                if (time + nextTime < dist[nextId]) {
                    dist[nextId] = time + nextTime;
                    pq.offer(new Node(nextId, dist[nextId]));
                    res[nextId] = res[id];
                } else if (time + nextTime == dist[nextId]) {
                    res[nextId] = (res[nextId] + res[id]) % mod;
                }
            }
        }

        return res[n - 1];
    }
}