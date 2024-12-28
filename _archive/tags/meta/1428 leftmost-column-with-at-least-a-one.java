/*
https://leetcode.com/problems/leftmost-column-with-at-least-a-one/

从右上角开始扫描，如果遇到零，i++
如果是1，那么先找到这行最左边的1
任何时刻j为0可以直接返回
找到最左边1时记录好位置，之后继续从下一行开始寻找

Time: O(m + n)
Space: O(1)
*/

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int m = d.get(0), n = d.get(1), i = 0, j = n - 1, res = n;
        while (i < m && j >= 0) {
            int cur = binaryMatrix.get(i, j);
            if (cur == 0) i++;
            else {
                while (j >= 0 && cur == 1) {
                    if (j == 0) return 0;
                    res = Math.min(res, j);
                    cur = binaryMatrix.get(i, --j);
                }
                i++;
            }
        }
        return res == n ? -1 : res;
    }
}