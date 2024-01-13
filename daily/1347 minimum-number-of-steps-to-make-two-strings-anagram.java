/*
https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

因为两个str长度相等，统计每个字符在str出现的次数差的和一定为0，即有的多，有的少，多和少的量是一样的
所以只要统计大于零或者小于零的频率即可，即用出现大于零的换成出现小于零的字符即可完成转换

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minSteps(String s, String t) {
        int[] m = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            m[sc - 'a']++;
            m[tc - 'a']--;
        }
        int res = 0;
        for (int num : m) {
            if (num > 0) res += num;
        }
        return res;
    }
}