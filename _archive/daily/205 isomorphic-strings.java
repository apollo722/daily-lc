/*
https://leetcode.com/problems/isomorphic-strings/

用map装映射关系
因为不同的字符也不能对应同一个字符，所以正反映射都要记录
也可以记录一个映射之后走一遍转换，看转换后的字符串是否等于t

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> ms = new HashMap<>();
        HashMap<Character, Character> mt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (!ms.containsKey(sc)) {
                ms.put(sc, tc);
            } else {
                if (ms.get(sc) != tc) return false;
            }
            if (!mt.containsKey(tc)) {
                mt.put(tc, sc);
            } else {
                if (mt.get(tc) != sc) return false;
            }
        }
        return true;
    }
}