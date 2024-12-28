/*
https://leetcode.com/problems/make-three-strings-equal/

从三个str中找到最长的前缀位置，余下的长度和即为答案
如果没有公共前缀，直接返回-1

Time: O(min(len))
Space: O(1)
*/

class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2 && k < len3) {
            if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
                i++;
                j++;
                k++;
            } else break;
        }
        if (i == 0 || j == 0 || k == 0) return -1;
        return len1 - i + len2 - j + len3 - k;
    }
}