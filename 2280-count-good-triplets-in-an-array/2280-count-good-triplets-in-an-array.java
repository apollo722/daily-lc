/*
找二元，三元对个数的题目要有一种固定一个元素，找其他元素的思路。
比如找二元，那么先固定一个，找满条件的另一个元素的个数。
本题三元对，那么先固定中间的一个，y，之后分别统计x与z的个数。
x即在两个数组都在y前面的个数，z即在两个数组都在y后面的个数。

如何固定一个y快速找到x或者z呢？这道题有个很巧妙的想法。
题目里有个条件是两个数组都一定是0到n-1的permutations，如何利用起来这个条件呢？
其实每个位置是什么并不重要。比如例子2中的nums1，[4,0,1,3,2]，就可以把它想象成[0,1,2,3,4]
之后把对应关系映射到nums2上，变为[0,2,1,4,3]。
这样做之后，就把找位置，变换成了找大小。
即找变化后数组中，统计任何一个位置，两个数组中，有多少个元素在它前面比它小，和在它后面比它大。
比如，原来数组中，(4,0,3)是一个合法对。在变化后的数组中，它变成了(0,1,3)。
即，统计在两个数组中的值都是递增的三元对个数。
因为nums1做了升序的变换，所以nums1自然而然都是升序。
nums2中统计升序对，根据之前的思想，可以固定中间的数，统计左侧有多少数字小于它，右侧有多少数字大于它，二者乘积就是结果。

上面的转化完成之后，就变成了统计转换完之后的nums2的每一个位置在其左侧比它小的元素个数，以及在其右侧比它大的元素个数。
315 Count of Smaller Numbers After Self 可以用分治归并排序来统计右侧小于固定元素的个数。
那么对于某个元素，位置为i，它右侧总共有n-i-1个元素，p个比它小的，必然有n-i-1个比它大的。
同理，对于某个元素，它的值是i，因为元素一定属于[0,n-1]，那么它是第i小的。
右侧有p个比它小的，那么左侧就有i-p个比它小的。
这样，利用315的答案就可以求出两侧需要的所有信息。

Time: O(NlogN)
Space: O(N)
*/

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        long res = 0;
        int n = nums1.length;
        int[] mapping = new int[n];
        for (int i = 0; i < n; i++) {
            mapping[nums1[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            int cur = nums2[i];
            nums2[i] = mapping[cur];
        }
        long[] smallerRight = countSmallerRight(nums2);
        long[] largerRight = new long[n];
        for (int i = 0; i < n; i++) {
            largerRight[i] = (n - 1 - i) - smallerRight[i];
        }
        long[] smallerLeft = new long[n];
        for (int i = 0; i < n; i++) {
            smallerLeft[i] = nums2[i] - smallerRight[i];
        }
        for (int i = 0; i < n; i++) {
            res += smallerLeft[i] * largerRight[i];
        }
        return res;
    }
    
    long[] resArr;
    public long[] countSmallerRight(int[] nums) {
        int n = nums.length;
        resArr = new long[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        solve(nums, indices, 0, n - 1);
        return resArr;
    }

    private void solve(int[] nums, int[] indices, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        solve(nums, indices, l, mid);
        solve(nums, indices, mid + 1, r);
        int i = l, j = mid + 1, p = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                resArr[indices[i]] += j - (mid + 1);
                tmp[p++] = indices[i];
                i++;
            } else {
                tmp[p++] = indices[j];
                j++;
            }
        }
        while (i <= mid) {
            resArr[indices[i]] += j - (mid + 1);
            tmp[p++] = indices[i];
            i++;
        }
        while (j <= r) {
            tmp[p++] = indices[j];
            j++;
        }
        for (int k = l; k <= r; k++) {
            indices[k] = tmp[k - l];
        }
    }
}