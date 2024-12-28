/*
https://leetcode.com/problems/reverse-prefix-of-word/

代码题

Time: O(n)
Space: O(n)
*/

class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            res.append(c);
            if (c == ch) {
                return res.reverse().toString() + word.substring(i + 1);
            }
        }
        return word;
    }
}