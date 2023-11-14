/*
https://leetcode.com/problems/unique-length-3-palindromic-subsequences/

找到每个letter的起始和最终index
在每个letter的range统计不同的字符出现的个数
加总即为最终答案

Time: O(n)
Space: O(1)
*/

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        int n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
            char cf = s.charAt(i), cl = s.charAt(n - i - 1);
            if (first[cf - 'a'] == -1) first[cf - 'a'] = i;
            if (last[cl - 'a'] == -1) last[cl - 'a'] = n - i - 1;
        }
        for (int i = 0; i < 26; i++) { 
            if (first[i] < last[i]) {
                HashSet<Character> set = new HashSet<>();
                for (int j = first[i] + 1; j < last[i]; j++) {
                    set.add(s.charAt(j));
                }
                res += set.size();
            }
        }
        return res;
    }
}