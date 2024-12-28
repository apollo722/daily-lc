/*
https://leetcode.com/problems/faulty-sensor/

比较巧妙的题
如果数组1可以移动一格到数组2，那么数组1就是答案
但如果同时数组2可以移动一格到数组1，那么就没法判断了
所以要检查两个数组是否可以互相移动1格到对方
如果都可以或者都不可以，那就返回-1，即无法判断
否则，返回那个能移动1格到另一个数组的数组

Time: O(n)
Space: O(1)
*/

class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        boolean res1 = check(sensor1, sensor2), res2 = check(sensor2, sensor1);
        if (res1 == res2) return -1;
        return res1 ? 1 : 2;
    }

    private boolean check(int[] a, int[] b) {
        int i = 0, j = 0;
        while (j < b.length) {
            if (a[i] != b[j]) j++;
            else {
                i++;
                j++;
            }
        }
        return i == b.length - 1;
    }
}