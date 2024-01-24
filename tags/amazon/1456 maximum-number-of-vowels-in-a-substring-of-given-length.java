/*
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

sliding window模板

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int l = 0, r = 0, n = s.length(), cnt = 0, res = 0;
        while (r < n) {
            char c = s.charAt(r);
            if (set.contains(c)) {
                cnt++;
            }
            if (r - l + 1 > k) {
                if (set.contains(s.charAt(l++))) cnt--;
            }
            res = Math.max(res, cnt);
            if (res == k) return k;
            r++;
        }
        return res;
    }
}