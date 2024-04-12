/*
https://leetcode.com/problems/ransom-note/

统计频率即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] m = new int[26];
        for (char c : magazine.toCharArray()) m[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (--m[c - 'a'] < 0) return false;
        }
        return true;
    }
}