/*
https://leetcode.com/problems/compare-version-numbers/

代码题，注意java split "." 需要 "\\."

Time: O(m + n)
Space: O(m + n)
*/

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int idx = 0, n1 = v1.length, n2 = v2.length;
        while (idx < n1 || idx < n2) {
            int d1 = idx < n1 ? Integer.valueOf(v1[idx]) : 0;
            int d2 = idx < n2 ? Integer.valueOf(v2[idx]) : 0;
            if (d1 < d2) return -1;
            else if (d1 > d2) return 1;
            else idx++;
        }
        return 0;
    }
}