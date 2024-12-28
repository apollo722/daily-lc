/*
https://leetcode.com/problems/sum-of-square-numbers/

利用two pointer，分别从0和sqrt(c)开始找
注意ceil后的sqrt(c)再平方有可能会超过max int，所以要用long转换

Time: O(sqrt(c))
Space: O(1)
*/

class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.ceil(Math.sqrt(c));
        while (a <= b) {
            long cur = a * a + (long) b * b;
            if (cur == c) return true;
            else if (cur < c) a++;
            else b--;
        }
        return false;
    }
}