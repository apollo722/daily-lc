/*
https://leetcode.com/problems/sparse-matrix-multiplication/

利用list of list存储非零的元素和位置，之后按照矩阵相乘的定义计算结果即可

Time: O(mnk)
Space: O(mk + kn)
*/

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        List<List<Pair<Integer, Integer>>> l1 = getList(mat1), l2 = getList(mat2);
        int m = mat1.length, n = mat2[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            List<Pair<Integer, Integer>> row = l1.get(i);
            for (Pair<Integer, Integer> p : row) {
                int num1 = p.getValue(), col1 = p.getKey();
                for (Pair<Integer, Integer> p2 : l2.get(col1)) {
                    int num2 = p2.getValue(), col2 = p2.getKey();
                    res[i][col2] += num1 * num2;
                }
            }
        }
        return res;
    }

    private List<List<Pair<Integer, Integer>>> getList(int[][] mat) {
        List<List<Pair<Integer, Integer>>> res = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            List<Pair<Integer, Integer>> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) row.add(new Pair(j, mat[i][j]));
            }
            res.add(row);
        }
        return res; 
    }
}