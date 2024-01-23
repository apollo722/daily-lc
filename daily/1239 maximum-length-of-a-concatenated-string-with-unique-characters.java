/*
https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

暴力求解，只能把每一个组合都试一下，即backtracking模板
对于看是否存在dup的char，可以提前用bitmask计算好

Time: O(2^n + nk)，k为单词平均长度
Space: O(n)
*/

class Solution {
    int res = 0;
    int[] m;
    public int maxLength(List<String> arr) {
        int n = arr.size();
        m = new int[n];
        for (int i = 0; i < n; i++) {
            String w = arr.get(i);
            int cur = 0;
            for (char c : w.toCharArray()) {
                if (((cur >> (c - 'a')) & 1) != 0) {
                    cur = -1;
                    break;
                }
                cur |= (1 << (c - 'a'));
            }
            m[i] = cur;
        }
        backtrack(arr, 0, 0, 0);
        return res;
    }

    private void backtrack(List<String> arr, int idx, int cur, int curSum) {
        if (idx == arr.size()) {
            res = Math.max(res, curSum);
            return;
        }
        for (int i = idx; i < arr.size(); i++) {
            int next = m[i];
            if (next == -1 || ((next & cur) != 0)) backtrack(arr, i + 1, cur, curSum);
            else backtrack(arr, i + 1, cur | next, curSum + arr.get(i).length());
        }
    }
}