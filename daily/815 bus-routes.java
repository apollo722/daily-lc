/*
https://leetcode.com/problems/bus-routes/

以stop作为图的节点进行BFS
每次找到包含stop的所有bus线
之后扫描所有bus线里面的stop
扫描过的bus线不用再扫描了

Time: O(mn)，n条线，每条线平均m stop
Space: O(mn)
*/

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!g.containsKey(stop)) g.put(stop, new ArrayList<>());
                g.get(stop).add(i);
            }
        }
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] visited = new boolean[routes.length];
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                int curStop = q.poll();
                List<Integer> busList = g.get(curStop);
                for (int bus : busList) {
                    if (visited[bus]) continue;
                    visited[bus] = true;
                    for (int next : routes[bus]) {
                        if (next == target) return res;
                        q.add(next);
                    }
                }
            }
        }
        return -1;
    }
}