/*
https://leetcode.com/problems/buddy-strings/

若长度不一样，则返回false
若二者相等，只要有任何一个字符出现大于1次，则返回true
其他情况，即需要找到两个字符位置不同的下标
如果只找到一个或者找到多于一个，则返回false
找到两个，则需要看两个str对应两个下标位置互相相等（可互换）


Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean buddyStrings(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) return false;
        if (s.equals(goal)) {
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
                if (map[c - 'a'] > 1) return true;
            }
        }
        int idx1 = -1, idx2 = -1;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (idx1 == -1) idx1 = i;
                else if (idx2 == -1) idx2 = i;
                else return false;
            }
        }
        if (idx2 == -1) return false;
        return s.charAt(idx1) == goal.charAt(idx2) && s.charAt(idx2) == goal.charAt(idx1);
    }
}