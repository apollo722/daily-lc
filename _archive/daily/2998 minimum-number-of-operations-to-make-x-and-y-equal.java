/*
https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/

转化为BFS的问题，即每一步可以有四种选择，优先达到y处即可

Time: ?，复杂度应该最多不超过x与y的差
Space: ?
*/

class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) return y - x;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(x);
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                int[] nexts = new int[]{cur + 1, cur - 1, cur % 11 == 0 ? cur / 11 : cur, cur % 5 == 0 ? cur / 5 : cur};
                for (int next : nexts) {
                    if (next == y) return res;
                    if (!visited.contains(next)) {
                        q.add(next);
                        visited.add(next);
                    }
                }   
            }
        }
        return -1;
    }
}