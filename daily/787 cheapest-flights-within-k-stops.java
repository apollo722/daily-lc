/*
https://leetcode.com/problems/cheapest-flights-within-k-stops/

两种做法
1. Bellman Ford
即扫描所有的边最多v-1次，只要找到找到比之前存储的更小的距离，就更新
因为有k的限制，所以利用dp扫描k次，找其中最好的

Time: O((v + e)k)
Space: O(v)

2. Dijkstra
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            int u = f[0], v = f[1], fee = f[2];
            g.get(u).add(new int[]{v, fee});
        }
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int s = 0; s < size; s++) {
                int[] tmp = pq.poll();
                int cur = tmp[0], fee = tmp[1], stop = tmp[2];
                List<int[]> nextList = g.get(cur);
                if (stop > k + 1 || stop > stops[cur]) continue;
                stops[cur] = stop;
                if (cur == dst) return fee;
                for (int[] next : nextList) {
                    int nextNode = next[0], nextFee = next[1];
                    pq.add(new int[]{nextNode, fee + nextFee, stop + 1});
                }
            }
        }

        return -1;
    }
}

Time: O(v + eklog(ek))
Space: O(v + ek)
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] tmp = dp.clone();
            for (int[] f : flights) {
                int u = f[0], v = f[1], fee = f[2];
                if (dp[u] < Integer.MAX_VALUE) {
                    tmp[v] = Math.min(tmp[v], fee + dp[u]);
                }
            }
            dp = tmp;
        }
        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }
}