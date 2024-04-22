/*
https://leetcode.com/problems/kill-process/

BFS模板
先构建图，之后标准BFS

Time: O(n)
Space: O(n)
*/

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int v = pid.get(i), u = ppid.get(i);
            if (!g.containsKey(u)) g.put(u, new ArrayList<>());
            g.get(u).add(v);
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        res.add(kill);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!g.containsKey(cur)) continue;
            for (int next : g.get(cur)) {
                res.add(next);
                q.add(next);
            }
        }
        return res;
    }
}