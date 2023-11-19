/*
https://leetcode.com/problems/count-k-subsequences-of-a-string-with-maximum-beauty/

先将字符出现的频率排序
如果k大于出现过的不同字符数，直接返回0

假设需要的k个字符中，最小的频率是limit
也就是说所有频率大于limit的字符一定会入选
所有频率小于limit的字符一定不会入选，否则肯定不够选出最大的结果
剩下等于limit的字符，可以以组合的形式选出剩余部分

所以频率大于limit的部分优先选择
统计剩下频率等于limit的部分
通过排列组合将余下的可能性计算入结果

Time: O(n)
Space: O(1)
*/

class Solution {
    long mod = (long) 1e9 + 7;
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int[] m = new int[26];
        for (char c : s.toCharArray()) m[c - 'a']++;
        Arrays.sort(m);
        if (k > 26 || m[26 - k] == 0) return 0;
        long res = 1, limit = m[26 - k], candidate = 0;
        for (int cnt : m) {
            if (cnt > limit) {
                k--;
                res = res * cnt % mod;
            } else if (cnt == limit) candidate++;
        }
        
        long combo = 1;
        for (int i = 1; i <= k; i++) {
            combo = combo * (candidate - (i - 1)) % mod / i;
            res = res * limit % mod;
        }
        return (int) (res * combo % mod);
    }
}