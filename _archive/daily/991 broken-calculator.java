/*
https://leetcode.com/problems/broken-calculator/

反向思维，target要么+1，要么除以2
当target能除以2的时候，一定是除以2最快，否则就要+1
那么当startValue不足target的时候，target就要尽量除以2，且target要在偶数的时候才能除以2
一旦startValue大于target，结果就是当前需要的步数+二者差

Time: O(log(target))
Space: O(1)
*/

class Solution {
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while (target > startValue) {
            res++;
            if (target % 2 == 1) target++;
            else target /= 2;
        }
        return res + startValue - target;
    }
}