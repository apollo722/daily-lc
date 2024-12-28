/*
https://leetcode.com/problems/bulb-switcher/

只能观察和记住
最后能留住的一定是有奇数个因数
比如1，4，9，16，分别有
(1)，(1,2,4)，(1,3,9)，(1,2,4,8,16)作为因数
奇数个因数的灯最后都能留下，因为开关奇数次灯最后为亮
所以就等于求[1,n]中有多少个奇数个因数的数字
观察后发现只有完全平方数有奇数个因数，而[1,n]总共有sqrt(n)个完全平方数，故为结果

Time: O(1)
Space: O(1)
*/

class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}