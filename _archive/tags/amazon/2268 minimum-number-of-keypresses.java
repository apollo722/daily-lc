/*
https://leetcode.com/problems/minimum-number-of-keypresses/

按频率排序，由频率高到低循环分配给1-9

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minimumKeypresses(String s) {
        int[] m = new int[26];
        for (int i = 0; i < s.length(); i++) {
            m[s.charAt(i) - 'a']++;
        }
        Arrays.sort(m);
        int cur = 1, cnt = 1, res = 0;
        for (int i = 25; i >= 0; i--) {
            if (cur > 9) {
                cnt++;
                cur = 1;
            }
            if (m[i] == 0) break;
            res += m[i] * cnt;
            cur++;
        }
        return res;
    }
}