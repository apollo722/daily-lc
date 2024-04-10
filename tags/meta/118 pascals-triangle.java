/*
https://leetcode.com/problems/pascals-triangle/

每层顺序处理即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        res.add(l);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> prev = res.get(i - 2);
            l = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) l.add(1);
                else {
                    l.add(prev.get(j - 1) + prev.get(j));
                }
            }
            res.add(l);
        }
        return res;
    }
}