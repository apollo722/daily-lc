/*
https://leetcode.com/problems/determine-if-two-strings-are-close/

因为任意位置的两个字符可以互换，即字符可以形成任何排列，又因为可以将所有a换成b，即频率也可以互换
所以只要两个字符串互相的字符都有，且出现的频率分布一致即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] m1 = new int[26], m2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            m1[word1.charAt(i) - 'a']++;
            m2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (m1[i] > 0 && m2[i] == 0) return false;
        }
        Arrays.sort(m1);
        Arrays.sort(m2);
        for (int i = 0; i < 26; i++) {
            if (m1[i] != m2[i]) return false;
        }
        return true;
    }
}