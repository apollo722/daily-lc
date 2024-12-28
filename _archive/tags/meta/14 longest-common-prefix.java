/*
https://leetcode.com/problems/longest-common-prefix/

逐个str比较，每次找到最长的公共前缀，用以比较后续的str

Time: O(nk)
Space: O(n)
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String cur = strs[i];
            int j = 0;
            for (; j < Math.min(cur.length(), res.length()); j++) {
                if (cur.charAt(j) != res.charAt(j)) break;
            }
            res = res.substring(0, j);
            if (res.length() == 0) return "";
        }
        return res;
    }
}