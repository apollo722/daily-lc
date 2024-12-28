/*
https://leetcode.com/problems/bitwise-and-of-numbers-range/

通过思考，可以发现只要有任何一位是0，最后的结果对应的位就一定是0
那么最后的结果就只跟所有数字的common prefix位有关
所以只要找到二者的commone prefix，其它位置零即可
其中一种做法是利用n&(n-1)会把最后一位1置0的性质，把right最后都置0，直到right不再大于left
比如9和12
1 0 0 1
1 1 0 0 -> 1 0 0 0 = 8

还有种做法是将left与right一直右移直到二者相等，再左移right之前的移动次数即可

Time: O(1)
Space: O(1)
*/

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}