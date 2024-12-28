/*
https://leetcode.com/problems/a-number-after-a-double-reversal/

除了0，末尾有0的数都不行。所以就看最后能不能被10整除

Time: O(1)
Space: O(1)
*/

class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        return num % 10 != 0;
    }
}