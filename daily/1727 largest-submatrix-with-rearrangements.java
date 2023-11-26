/*
https://leetcode.com/problems/largest-submatrix-with-rearrangements/

对于每一行，如果可以知道每一个col向上有多少个连续的1，且是按照连续1个数降序排列
那么就可以通过连续1个数 x 宽度来求出当前cell最大矩形面积
比如
1 0 0    1 0 0
1 0 1 -> 2 1 0 -> 2 2 0 -> max area = 2
这样的需要O(mnlogn)的时间复杂的，因为要sort每一行

也可以利用以下算法来有序记录每一个扫描过的位置

Time: O(mn)
Space: O(n)
*/

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Pair<Integer, Integer>> prev = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            List<Pair<Integer, Integer>> cur = new ArrayList<>();
            boolean[] visited = new boolean[n];
            for (Pair<Integer, Integer> p : prev) {
                int h = p.getKey(), j = p.getValue();
                if (matrix[i][j] == 1) {
                    cur.add(new Pair(h + 1, j));
                    visited[j] = true;
                }
            }

            for (int j = 0; j < n; j++) {
                if (!visited[j] && matrix[i][j] == 1) cur.add(new Pair(1, j));
            }

            for (int j = 0; j < cur.size(); j++) {
                res = Math.max(res, cur.get(j).getKey() * (j + 1));
            }

            prev = cur;
        }
        return res;
    }
}