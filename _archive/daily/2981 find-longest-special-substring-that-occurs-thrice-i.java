/*
https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/

对比暴力解，即统计每一个只有一种字符的substr的频率，可以利用substr都是同一字符这一性质进行以下优化
如果一个substr是"aaaa"，那么"a"，"aa"，"aaa"，"aaaa"分别出现4，3，2，1次
所以并不需要单独统计字符重复次数更少的substr，只需要统计最长的单一字符的substr即可
剩下较短的直接可以通过长度计算出来
所以只要遍历所有最长的单一字符的substr即可，之后统计不同字符出现不同次数的频率即可
即用int[26][n]存储26个字符分别重复[1,n]次出现的频率，找到大于3次的最长重复即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int maximumLength(String s) {
        int n = s.length(), res = -1;
        char[] arr = s.toCharArray();
        int[][] m = new int[26][n];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && arr[j] == arr[i]) j++;
            int len = j - i, repeat = 0;
            for (int k = len; k > 0; k--, repeat++) {
                m[arr[i] - 'a'][repeat] += k;
                if (m[arr[i] - 'a'][repeat] > 2 && res < repeat + 1) res = repeat + 1;
            }
            i = j;
        }
        return res;
    }
}