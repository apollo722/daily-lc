/*
https://leetcode.com/problems/reorganize-string/

可以通过pq字符频率来模拟，如果前一个字符和当前队列头字符相同，就要查看队列的下一个，如果队列没有下一个了，即无法组成满足条件的str
也可以通过O(n)来直接组成结果
最大频率的字符需要穿插在所有的偶数下标，如果最大频率大于偶数下标的个数，即无法组成满足条件的结果
否则，直接把最大频率的字符穿插在偶数下标，剩下的字符一次穿插在剩下的下标位置即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public String reorganizeString(String s) {
        int[] m = new int[26];
        int maxFreq = 0, n = s.length();
        char maxChar = 'a';
        for (char c : s.toCharArray()) {
            m[c - 'a']++;
            if (m[c - 'a'] > maxFreq) {
                maxFreq = m[c - 'a'];
                maxChar = c;
            }
        }
        if (maxFreq > (n + 1) / 2) return "";
        char[] resArr = new char[n];
        int idx = 0;
        while (maxFreq-- > 0) {
            resArr[idx] = maxChar;
            m[maxChar - 'a']--;
            idx += 2;
        }
        for (int i = 0; i < 26; i++) {
            while (m[i]-- > 0) {
                if (idx >= n) idx = 1;
                resArr[idx] = (char)(i + 'a');
                idx += 2;
            }
        }
        return String.valueOf(resArr);
    }
}