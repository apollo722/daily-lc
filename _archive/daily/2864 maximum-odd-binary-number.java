/*
https://leetcode.com/problems/maximum-odd-binary-number/

统计1的个数，留一个放到末尾，剩下的放到前面，其它位补0

Time: O(n)
Space: O(n)
*/

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length(), cnt = 0;
        for (char c : s.toCharArray()) if (c == '1') cnt++;
        n -= cnt;
        StringBuilder res = new StringBuilder();
        while (cnt-- > 1) {
            res.append('1');
        }
        while (n-- > 0) res.append('0');
        res.append('1');
        return res.toString();
    }
}