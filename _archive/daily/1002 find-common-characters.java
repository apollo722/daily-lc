/*
https://leetcode.com/problems/find-common-characters/

代码题，每个字符需要全量检查一遍
注意的是检查的时候需要看每个字符在所有单词中出现的最小频率
比如一个字符在某个单词中出现两次，但在另一个单词中只出现一次，那么最后结果中只有一个该字符

Time: O(nk)
Space: O(1)
*/

class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int[] m = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            char c = words[0].charAt(i);
            m[c - 'a']++;
        }
        int[] cnt = new int[26];
        for (int i = 1; i < words.length; i++) {
            Arrays.fill(cnt, 0);
            for (int j = 0; j < words[i].length(); j++) {
                cnt[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                if (m[k] != 0) {
                    m[k] = Math.min(m[k], cnt[k]);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (m[i] > 0) {
                for (int j = 0; j < m[i]; j++) {
                    res.add("" + (char)(i + 'a'));
                }
            }
        }
        return res;
    }
}