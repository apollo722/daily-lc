/*
https://leetcode.com/problems/removing-minimum-number-of-magic-beans/

dijkstra模板

Time: O((e + v)log(e + v))
Space: O(e + v)
*/

class Solution {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        List<List<Pair<Integer, Integer>>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0] - 1, v = road[1] - 1, cost = road[2];
            g.get(u).add(new Pair(v, cost));
            g.get(v).add(new Pair(u, cost));
        }
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = appleCost[i];
        }

        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(a.getKey(), b.getKey()));
        for (int i = 0; i < n; i++) {
            pq.add(new Pair<>((long)appleCost[i], i));
        }
        
        while (!pq.isEmpty()) {
            Pair<Long, Integer> cur = pq.poll();
            long totalCost = cur.getKey();
            int curCity = cur.getValue();
            if (res[curCity] < totalCost) continue;
            for (Pair<Integer, Integer> next : g.get(curCity)) {
                int nextCity = next.getKey(), cost = next.getValue();
                if (res[nextCity] > res[curCity] + (k + 1) * cost) {
                    res[nextCity] = res[curCity] + (k + 1) * cost;
                    pq.add(new Pair<Long, Integer>(res[nextCity], nextCity));
                }
            }
        }
        return res;
    }
}