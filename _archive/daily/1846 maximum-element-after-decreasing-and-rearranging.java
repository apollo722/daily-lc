/*
https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/

排序贪心：排序之后if (arr[i] >= res + 1) res++;

不排序：
结果最大不会超过n，所以所有大于n的数字都可以算作n
统计每个数字出现的频率
之后从2到n，看每一个位置能不能被其他数字填充
填充最大不会超过位置大小
res = Math.min(res + counts[i], i);

比如 1 1 5，map[1:2, 3:1]
2时，没有2，所以此时res还是1
3时，有1个3，所以res + 1 = 2

如果是 1 5 5，map[1:1, 3:2]
2时，没有2，所以此时res还是1
3时，有2个3，所以res + 2 = 3，相当于既补充了2又满足了3

Time: O(n)
Space: O(n)
*/

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] counts = new int[n + 1];
        for (int num : arr) {
            counts[Math.min(n, num)]++;
        }
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = Math.min(res + counts[i], i);
        }
        return res;
    }
}