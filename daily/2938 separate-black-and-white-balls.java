/*
https://leetcode.com/problems/separate-black-and-white-balls/

每一个1被移动到最右所需要的step数取决于它右边有多少个0
比如1010
第一个1移动到最右需要交换2次
第二个1移动到最右需要交换1次

Time: O(n)
Space: O(1)
*/

class Solution {
    public long minimumSteps(String s) {
        long res = 0, cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cur++;
            else res += cur;
        }
        return res;
    }
}