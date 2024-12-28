/*
https://leetcode.com/problems/single-number/

bit运算
一个数异或自己是0，异或所有数，成对出现的都消失了，剩下的就是只出现一次的

Time: O(n)
Space: O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
            
        }
        return res;
    }
}