/*
https://leetcode.com/problems/adding-spaces-to-a-string/

没有特别的算法，遇到某个点直接加空格即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n = s.length(), idx = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (idx == spaces.length || i < spaces[idx]) res.append(s.charAt(i));
            else {
                res.append(" ");
                idx++;
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}