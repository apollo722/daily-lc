/*
https://leetcode.com/problems/product-of-two-run-length-encoded-arrays/

two pointer逐个检查
当和前面元素一致时要融合

Time: O(m + n)
Space: O(1)
*/

class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        int n = encoded1.length;
        int i = 0, j = 0;
        while (i < n) {
            int count = Math.min(encoded1[i][1], encoded2[j][1]);
            int val = encoded1[i][0] * encoded2[j][0];
            if (!res.isEmpty() && res.get(res.size() - 1).get(0) == val) {
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + count);
            } else res.add(Arrays.asList(val, count));
            encoded1[i][1] -= count;
            encoded2[j][1] -= count;
            if (encoded1[i][1] == 0) i++;
            if (encoded2[j][1] == 0) j++;
        }
        return res;
    }
}