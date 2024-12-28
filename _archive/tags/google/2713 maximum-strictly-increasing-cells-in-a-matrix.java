/*
https://leetcode.com/problems/maximum-strictly-increasing-cells-in-a-matrix/

自然的想法是从最小值开始，每次找更大一点点的跳，看能否接上之前值更小的地方
所以先把所有的值排序，从最小的开始走
每次走到一个位置时，分别看当前位置所在行和列，比其小的位置的步数
如果存在比其值更小的，那就继承步数（step + 1），之后更新值

每次在行或列寻找前值时，只用到了前一个更小的值，和再前一个值，如果有多个值相同的话
所以对于每个行列的查询，只需要存储两对数据，前一对，和当前一对的值和其相等时的再前一对

所以查询时，先看前一对是不是比当前值小，如果比当前值小，那么就取
如果和当前值一样，那就取另一对

所以更新数对时，要保证两对数值不一样且前对更小

Time: O(mnlogmn)
Space: O(mn)
*/

class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 1;
        int[][] arr = new int[m * n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i * n + j] = new int[]{i, j, mat[i][j]};
            }
        }
        int[][] row = new int[m][4], col = new int[n][4];
        for (int i = 0; i < m; i++) {
            row[i][0] = Integer.MIN_VALUE;
            row[i][2] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < n; i++) {
            col[i][0] = Integer.MIN_VALUE;
            col[i][2] = Integer.MIN_VALUE;
        }
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < m * n; i++) {
            int[] cur = arr[i];
            int r = cur[0], c = cur[1], v = cur[2];

            int curLen = 1;
            int rowLen = row[r][2] < v ? row[r][3] : row[r][1];
            curLen = Math.max(curLen, rowLen + 1);
            int colLen = col[c][2] < v ? col[c][3] : col[c][1];
            curLen = Math.max(curLen, colLen + 1);

            if (row[r][2] < v) {
                row[r][0] = row[r][2];
                row[r][1] = row[r][3];
            }
            row[r][2] = v;
            row[r][3] = Math.max(row[r][3], curLen);

            if (col[c][2] < v) {
                col[c][0] = col[c][2];
                col[c][1] = col[c][3];
            }
            col[c][2] = v;
            col[c][3] = Math.max(col[c][3], curLen);

            res = Math.max(res, curLen);
        }
        return res;
    }
}