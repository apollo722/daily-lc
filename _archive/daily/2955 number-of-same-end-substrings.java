/*
https://leetcode.com/problems/number-of-same-end-substrings/

任何query，如果知道每个字符出现的频率，就可以轻易算出结果
对于频率大于1的字符，相当于Cn_2种选择，即n(n - 1)/2个结果
再加上频率为1的，即query字符串长度
所以只要提前知道对应位置区间各字母的频率即可
利用prefix sum来求出每个字符的频率即可

Time: O(n + q)
Space: O(n + q)
*/

class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int n = s.length();
        int[] freq = new int[26];
        int[][] m = new int[26][n + 1];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                m[j][i + 1] = m[j][i] + (((c - 'a') == j) ? 1 : 0);
            }
        }
        int[] res = new int[queries.length];
        int idx = 0;
        for (int[] q : queries) {
            int start = q[0], end = q[1];
            for (int i = 0; i < 26; i++) {
                res[idx] += (m[i][end + 1] - m[i][start]) * (m[i][end + 1] - m[i][start] - 1) / 2;
            }
            res[idx++] += q[1] - q[0] + 1;
        }
        return res;
    }
}