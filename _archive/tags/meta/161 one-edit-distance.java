/*
https://leetcode.com/problems/one-edit-distance/

按顺序逐位比对，遇到不一样的位比较剩下的str即可
Java substring操作需要复制整段str，会消耗O(n) space，所以用额外的循环来比较余下的str

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS > lenT) return isOneEditDistance(t, s);
        if (lenS + 1 < lenT) return false;
        if (s.equals(t)) return false;
        for (int i = 0; i < lenS; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (lenS == lenT) return isEqual(s, t, i + 1, i + 1);
                return isEqual(s, t, i, i + 1);
            }
        }
        return true;
    }

    private boolean isEqual(String s, String t, int sIdx, int tIdx) {
        for (int i = sIdx; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(tIdx)) return false;
            tIdx++;
        }
        return true;
    }
}