/*
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

对于valid k，结果一定存在于matrix中，上下界分别为输入中最大和最小值，所以考虑用二分查找
对于有序matrix，线性的从右上角开始查找，看目标值在数组中排行第几
查找过程中需要记录数组内最大的小于等于目标的数，以及最小的大于目标的数
这是因为二分查找的mid不一定是数组中的数，所以每次缩小范围时，需要一个数组内的数来缩小范围
对于二分查找的终止条件，不能为l<=r
考虑[[1,2],[1,3]]，k=1的情况
当l=1,r=2时，mid=1，查找过后永远返回2，即1是第二小，后r=1，即l==r，会进入死循环
这是因为线性查找时找到的是右边界，即同样的元素在数组中最大排第几
所以循环内可能永远找不到答案，故在l==r，即搜索空间为0之后，要结束循环
最后返回l或r均可，因为l，r相等，且一定是数组中的元素了

Time: O(n log(max - min))
Space: O(1)
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        int[] p = new int[]{matrix[0][0], matrix[n - 1][n - 1]};
        while (l < r) {
            int mid = l + (r - l) / 2;
            p = new int[]{matrix[0][0], matrix[n - 1][n - 1]};
            int cur = check(matrix, mid, p);
            if (cur == k) return p[0];
            else if (cur < k) {
                l = p[1];
            } else {
                r = p[0];
            }
        }
        return l;
    }

    private int check(int[][] matrix, int tar, int[] p) {
        int n = matrix.length;
        int i = 0, j = n - 1, res = 0;
        while (i < n && j >= 0) {
            int cur = matrix[i][j];
            if (cur > tar) {
                p[1] = Math.min(p[1], cur);
                j--;
            } else {
                res += j + 1;
                p[0] = Math.max(p[0], cur);
                i++;
            }
        }
        return res;
    }
}