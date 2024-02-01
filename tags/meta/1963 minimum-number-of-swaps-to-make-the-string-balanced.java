/*
https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

括号问题常规扫描，任何balance小于零时就意味着发现一个mismatch
所有mismatch除以2，就是需要的交换次数
最后的+1是为了处理奇数个mismatch的情况
比如"]]][[["，三个mismatch至少需要两次交换，而"]][["只需要一次

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minSwaps(String s) {
        int balance = 0, n = s.length(), res = 0, misMatch = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '[') balance++;
            else {
                if (balance > 0) balance--;
                else misMatch++;
            }
        }
        return (misMatch + 1) / 2;
    }
}