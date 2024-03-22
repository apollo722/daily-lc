/*
https://leetcode.com/problems/remove-vowels-from-a-string/

不需要解释

Time: O(n)
Space: O(n)
*/

class Solution {
    public String removeVowels(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) == -1) res.append(c);
        }
        return res.toString();
    }
}