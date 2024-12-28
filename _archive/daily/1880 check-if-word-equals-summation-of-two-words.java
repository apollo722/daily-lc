/*
https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/

挑战下写代码能力的话就和两数相加一样判断所有情况
简单写法就按题意把两个str转化成数字即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int carry = 0, i = firstWord.length() - 1, j = secondWord.length() - 1, k = targetWord.length() - 1;
        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? firstWord.charAt(i) - 'a' : 0;
            int d2 = j >= 0 ? secondWord.charAt(j) - 'a' : 0;
            int total = d1 + d2 + carry;
            int d = total % 10;
            carry = total / 10;
            if (k < 0) {
                if (d != 0) return false;
            }
            else if (targetWord.charAt(k) - 'a' != d) return false;
            else k--;
            i--;
            j--;
        }
        while (k >= 0) {
            if (targetWord.charAt(k) - 'a' != carry) return false;
            carry = Math.max(0, carry - 1);
            k--;
        }
        return carry == 0;
    }
}