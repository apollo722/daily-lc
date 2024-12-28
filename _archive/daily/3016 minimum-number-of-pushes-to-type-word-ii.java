/*
https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

按照频率排序，频率大的先安排在各个数字的首位，直到填满，以此类推
因为只有八个能按的数字，所以每八个轮一遍即可

Time: O(1)
Space: O(1)
*/

class Solution {
    public int minimumPushes(String word) {
        int[] m = new int[26];
        for (char c : word.toCharArray()) m[c - 'a']++;
        Arrays.sort(m);
        int res = 0;
        for (int i = 25; i >= 0; i--) {
            if (i > 17) res += m[i];
            else if (i > 9) res += 2 * m[i];
            else if (i > 1) res += 3 * m[i];
            else res += 4 * m[i];
        }
        return res;
    }
}