/*
https://leetcode.com/problems/maximum-gap/

桶排序思想
如果想找到有序数列元素间最大值，需要排序并比较每两个元素
如果把元素分组，且记录每组元素的最大值与最小值，如果能只比较组与组间的元素差能找到gap，就能更高效
问题是怎么样分组
n个元素总共会有n-1个gap，而每个gap平均t=(max-min)/(n-1)，也就是如果一个桶里面装范围为t的元素
那么总共需要(max-min)/t + 1个桶
这样做为什么能保证最大gap一定存在于组间而不是组内呢？
假设数组是个等差数列[1,3,5,7,9]，那么gap一定是公差2，且每个组只有一个元素
如果不是等差数列，[1,3,5,6,9]，即一定有组元素多一些，有的组元素少一些，元素多一些的组的组间元素差势必小于平均gap t
那么证明一定有元素和它下一个元素的gap是大于t的
因为等差数列的情况的t一定是所有情况中最小的，所以任何其他情况的gap一定都存在于组间
所以只要保证每个桶装的元素范围小于等于t即可，即取个floor
最后记录每个桶中的最大与最小值，组间比较前桶的最大值与后桶的最小值的差即可

Time: O(n)
Space: O(b)，b为桶数
*/

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = nums.length;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int t = Math.max(1, (max - min) / (n - 1));
        int[][] bucket = new int[(max - min) / t + 1][2];
        for (int[] b : bucket) Arrays.fill(b, -1);
        for (int num : nums) {
            int idx = (num - min) / t;
            if (bucket[idx][0] == -1) {
                bucket[idx][0] = num;
                bucket[idx][1] = num;
            } else {
                bucket[idx][0] = Math.min(num, bucket[idx][0]);
                bucket[idx][1] = Math.max(num, bucket[idx][1]);
            }
        }
        int res = 0, prev = -1;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i][0] == -1) continue;
            if (prev == -1) prev = bucket[i][1];
            else {
                res = Math.max(res, bucket[i][0] - prev);
                prev = bucket[i][1];
            }
        }
        return res;
    }
}