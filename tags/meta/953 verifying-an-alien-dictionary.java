/*
https://leetcode.com/problems/verifying-an-alien-dictionary/

检查相邻的每一对单词，逐个对比每一个位置看是否符合order顺序

Time: O(nk)，k为单词平均长度
Space: O(1)
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            m.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            String cur = words[i], prev = words[i - 1];
            int l1 = 0, l2 = 0;
            while (l1 < prev.length() && l2 < cur.length()) {
                char c1 = prev.charAt(l1), c2 = cur.charAt(l2);
                if (c1 != c2) {
                    if (m.get(c1) > m.get(c2)) return false;
                    break;
                }
                l1++;
                l2++;
            }
            if (l2 == cur.length() && l1 < prev.length()) return false;
        }
        return true;
    }
}