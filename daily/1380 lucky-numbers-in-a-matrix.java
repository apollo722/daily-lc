/*
https://leetcode.com/problems/lucky-numbers-in-a-matrix/

代码题
逻辑上可以知道最多只有一个点是lucky的
所以可以先找到每行的最小值，在这些最小值中找到最大的
列同理，找到每列最大的，之后再找其中最小的
如果它们相等，即返回
否则就是空

Time: O(mn)
Space: O(1)
*/

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        HashSet<Integer> minSet = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int[] r : matrix) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < r.length; i++) {
                min = Math.min(min, r[i]);
            }
            minSet.add(min);
        }
        for (int i = 0; i < matrix[0].length; i++) {     
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            if (minSet.contains(max)) res.add(max);
        }
        return res;
    }
}