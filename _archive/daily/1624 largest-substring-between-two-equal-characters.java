/*
https://leetcode.com/problems/largest-substring-between-two-equal-characters/

利用map直接求解

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (m.containsKey(c)) res = Math.max(res, i - m.get(c) - 1);
            else m.put(c, i);
        }
        return res;
    }
}