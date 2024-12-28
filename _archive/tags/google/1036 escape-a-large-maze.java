/*
https://leetcode.com/problems/escape-a-large-maze/

取巧因为block数量有限，所以一旦延展超过block能围起来的最大范围，即不用继续搜索了

Time: O(1)
Space: O(1)
*/

class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    int n = (int) 1e6;
    int limit = 19900;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) return true;
        HashSet<Pair<Integer, Integer>> blocks = new HashSet<>();
        for (int[] b : blocked) {
            blocks.add(new Pair(b[0], b[1]));
        }
        return bfs(source, target, blocks) && bfs(target, source, blocks);
    }

    private boolean bfs(int[] s, int[] t, HashSet<Pair<Integer, Integer>> blocks) {
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(s);
        visited.add(new Pair(s[0], s[1]));
        while (!q.isEmpty() && visited.size() <= 19900) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int x = cur[0] + dir[d], y = cur[1] + dir[d + 1];
                Pair<Integer, Integer> p = new Pair(x, y);
                if (x >= 0 && y >= 0 && x < n && y < n && !visited.contains(p) && !blocks.contains(p)) {
                    if (x == t[0] && y == t[1]) return true;
                    visited.add(p);
                    q.add(new int[]{x, y});
                }
            }
        }
        return visited.size() > 19900;
    }
}