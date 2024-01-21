/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

想一箭射更多的气球，要贪心的射气球的末尾，因为这样可以尽可能的覆盖更多位置
所以按照末尾排序，从第一个末尾开始检查
如果前一个的末尾在下一个气球的范围内，那么下一个气球就可以被同一支箭射穿
否则需要一直新的箭，新的箭继续尽可能的靠后，即射末尾

Time: O(nlogn)
Space: O(logn)，排序所需空间
*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n < 2) return n;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int res = 1;
        int curEnd = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= curEnd && curEnd <= points[i][1]) continue;
            else {
                res++;
                curEnd = points[i][1];
            }
        }
        return res;
    }
}