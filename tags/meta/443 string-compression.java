/*
https://leetcode.com/problems/string-compression/

利用原数组统计+replace

Time: O(n)
Space: O(1)
*/

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int l = 0, r = 0, idx = 0;
        while (l < n) {
            char c = chars[l];
            while (r < n && c == chars[r]) r++;
            int cnt = r - l;
            chars[idx++] = c;
            if (cnt > 1) {
                for (char d : (cnt + "").toCharArray()) chars[idx++] = d;
            }
            l = r; 
        }
        return idx;
    }
}