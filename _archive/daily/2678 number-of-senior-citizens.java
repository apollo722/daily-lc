/*
https://leetcode.com/problems/number-of-senior-citizens/

代码题

Time: O(n)
Space: O(1)
*/

class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for (String str : details) {
            if (Integer.valueOf(str.substring(11, 13)) > 60) res++;
        }
        return res;
    }
}