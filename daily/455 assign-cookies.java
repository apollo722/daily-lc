/*
https://leetcode.com/problems/assign-cookies/

greedy的把最小的饼干分配给最小的可以被分配的人
分别排序饼干和人即可

Time: O(nlogn + mlogm)
Space: O(logn + logm)
*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, m = g.length, n = s.length, res = 0;
        while (i < m && j < n) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                res++;
            } else j++;
        }
        return res;
    }
}