/*
https://leetcode.com/problems/plates-between-candles/

一开始想的是统计每个candle的位置，之后利用二分查找找到最近的边界
再利用preSum计算每个位置总共多少plate来计算

其实可以O(n)的统计每个位置左右两侧最近的candle处能见到的plate，例如：
0 0 0 1 0 1 0
3 3 3 3 4 4 4
0 0 0 3 3 4 4

计算左边界的plate，只要每遇到一个candle就将它左侧到上一个candle之间的位置置成目前有的plate数即可
计算右边界的plate，只要把每个位置都置成此时candle遇到过的plate数即可

Time: O(n + m)
Space: O(n)
*/

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length(), cnt = 0, curSum = 0, prev = -1;
        int[] closeLeft = new int[n], closeRight = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                curSum = cnt;
                for (int j = i; j > prev; j--) closeLeft[j] = curSum;
                prev = i;
            } else {
                cnt++;
            }
            closeRight[i] = curSum;
        }
        for (int i = prev + 1; i < n; i++) closeLeft[i] = curSum;
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int lCnt = closeLeft[l], rCnt = closeRight[r];
            if (rCnt - lCnt < 0) res[i] = 0;
            else res[i] = rCnt - lCnt;
        }
        return res;
    }
}