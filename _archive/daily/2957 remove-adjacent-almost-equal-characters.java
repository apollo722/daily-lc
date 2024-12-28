/*
https://leetcode.com/problems/remove-adjacent-almost-equal-characters/

逐个检查，如果找到差值小于1的字符对，结果就加1，并且idx += 2，否则idx += 1
因为最后结果不要求找到满足条件的str，而只是统计需要多少次operation
任意三个字母，更改中间的那个一定会让这三个字母满足条件，而不必知道到底改成哪个字母

Time: O(n)
Space: O(1)
*/

class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int res = 0, n = word.length(), i = 1;
        while (i < n) {
            if (Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 1) {
                res++;
                i += 2;
            } else i++;
        }
        return res;
    }
}