/*
https://leetcode.com/problems/find-the-town-judge/

用额外数组存储出度入度的信息，只有最后入度是-(n-1)的才是结果，不存在返回-1

Time: O(n)
Space: O(n)
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] m = new int[n];
        for (int[] t : trust) {
            m[t[0] - 1]++;
            m[t[1] - 1]--;
        }
        for (int i = 0; i < n; i++) {
            if (m[i] == -(n - 1)) return i + 1;
        }
        return -1;
    }
}