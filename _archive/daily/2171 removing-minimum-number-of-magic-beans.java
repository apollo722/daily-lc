/*
https://leetcode.com/problems/removing-minimum-number-of-magic-beans/

排序后，扫描每个元素，把它当作最后结果数组中的一致元素
那么它前面所有元素和，加上它及后面所有元素和减去它及后面元素个数乘以它的值，就是cost
简化之后就变成了total - (n - i) * cur

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long n = beans.length;
        long total = 0;
        for (int num : beans) total += num;
        long res = total;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, total - (n - i) * beans[i]);
        }
        return res;
    }
}