/*
https://leetcode.com/problems/spiral-matrix/

用四个变量分别track四个边界
按顺序逐个放入结果中
注意上下收缩时要检查上下边界不是同一个，左右边界同理
除了最后的下到上的是开区间，其它都是必区间
一圈之后缩小边界即可

Time: O(mn)
Space: O(1)
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (res.size() < m * n) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (top != bottom) {
                for (int j = right - 1; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
            }
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        
        return res;
    }
}