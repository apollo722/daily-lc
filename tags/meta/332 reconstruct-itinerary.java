/*
https://leetcode.com/problems/reconstruct-itinerary/

构建欧拉路径（不重复的只走每条边一次）
用DFS走从起始节点（此题已经明确起始节点一定为JFK）
有两种情况：1. 直接走到低了，证明此路不存在回路了，可以直接放在结果中；2. 又回到原来的地方了，证明有个圈，且还有剩下的没走完
只要保证情况1处于最终结果的末段即可
因此可以用stack来maintain所有的路段，这样如果直接找到了1，就直接返回，如果找到2，那先push到stack中，直到找到1
因为要按照字典序，所以直接用pq来决定接下来走哪里即可

Time: ?
Space: ?
*/

class Solution {
    HashMap<String, PriorityQueue<String>> g = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String fr = ticket.get(0), to = ticket.get(1);
            if (!g.containsKey(fr)) g.put(fr, new PriorityQueue<>());
            g.get(fr).add(to);
        }
        return dfs("JFK");
    }

    private List<String> dfs(String cur) {
        List<String> res = new ArrayList<>();
        PriorityQueue<String> pq = g.get(cur);
        Deque<List<String>> dq = new LinkedList<>();
        while (pq != null && !pq.isEmpty()) {
            dq.addLast(dfs(pq.poll()));
        }
        res.add(cur);
        while (!dq.isEmpty()) res.addAll(dq.pollLast());
        return res;
    }
}