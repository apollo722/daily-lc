/*
https://leetcode.com/problems/strobogrammatic-number/

枚举每种可能的情况，如果不匹配就直接返回false

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean isStrobogrammatic(String num) {
        Set<Character> s = new HashSet<>();
        s.add('2');
        s.add('3');
        s.add('4');
        s.add('5');
        s.add('7');
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            char lc = num.charAt(l), rc = num.charAt(r);
            if (s.contains(lc) || s.contains(rc)) return false;
            if (lc == '6' && rc != '9') return false;
            if (lc == '9' && rc != '6') return false;
            if (lc == '0' && rc != '0') return false;
            if (lc == '1' && rc != '1') return false;
            if (lc == '8' && rc != '8') return false;
            l++;
            r--;
        }
        return true;
    }
}