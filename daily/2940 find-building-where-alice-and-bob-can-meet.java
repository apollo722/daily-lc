/*
https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/

每个query有四种情况
1. i < j && heights[i] < heights[j]，在j处meet
2. i > j && heights[i] > heights[j]，在i处meet
3. i == j，在i处meet
4. 要求出第一个大于i，j且height大于max(heights[i], heights[j])的位置

每次扫描过一个heights[i]时，情况4中最大下标小于i的query就都可以尝试求解
所以可以统计每一个位置可以被求解的query
当顺序扫描heights时，每过一个位置i，即可将位置i可以求解的query放到待求解的列表中
因为只有当前位置heights[i]大于query的heights时才是解
所以可以把所有待求解的query放到pq中，这样每次扫描到一个heights[i]时，可以快速求解所有满足条件的query
扫描完所有heights之后，剩余的query即都为-1

Time: O(max(n, mlogm))，n为height长度，m为queries长度
Space: O(m)
*/

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length, m = queries.length;
        PriorityQueue<int[]> toAns = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        List<int[]>[] solveList = new ArrayList[n];
        for (int i = 0; i < n; i++) solveList[i] = new ArrayList<>();
        int[] res = new int[m];
        Arrays.fill(res, -1);
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l < r && heights[l] < heights[r]) res[i] = r;
            else if (l > r && heights[l] > heights[r]) res[i] = l;
            else if (l == r) res[i] = l;
            else {
                solveList[Math.max(l, r)].add(new int[]{i, Math.max(heights[l], heights[r])});
            }
        }
        for (int i = 0; i < n; i++) {
            while (!toAns.isEmpty() && toAns.peek()[1] < heights[i]) {
                res[toAns.poll()[0]] = i;
            }
            for (int[] canSolve : solveList[i]) {
                toAns.add(canSolve);
            }
        }
        return res;
    }
}