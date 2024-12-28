class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int l = 0, r = m, midLen = (m + n + 1) / 2;
        while (l <= r) {
            int partA = (l + r) / 2;
            int partB = midLen - partA;
            int maxLeftA = partA == 0 ? Integer.MIN_VALUE : nums1[partA - 1];
            int minRightA = partA == m ? Integer.MAX_VALUE : nums1[partA];
            int maxLeftB = partB == 0 ? Integer.MIN_VALUE : nums2[partB - 1];
            int minRightB = partB == n ? Integer.MAX_VALUE : nums2[partB];
            if (maxLeftA <= minRightB && minRightA >= maxLeftB) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else return Math.max(maxLeftA, maxLeftB);
            } else if (maxLeftA > minRightB) r = partA - 1;
            else l = partA + 1;
        }
        return 0.0;
    }
}


/*
由于中位数是有序数组最中间的数，所以需要解决:
1. 把整体数组分成数量相等的两半；
2. 左半边的数都小于右半边的数。

数组总长度是m+n，一半即(m+n+1)/2。这里+1是为了处理总长是奇数的情况，这样左半边的最后一个就是中位数。
如果把两个有序数组都分成两半，保证左边的两半总数是(m+n+1)/2，且左边两半的最大值都小于右边两半的最小值，这样就找到了总数各一半的分组，也就能求出中位数了。
接下来就要想怎么怎么样找分区。因为总数的一半是固定的(m+n+1)/2，如果第一个数组在partA处分割，另一个数组必然是在(m+n+1)/2-partA处分割，这样才能保证是总数是一半。
保证了数量是一半，接下来要保证左半边都是小于右半边的。
那么就看分割的两个左半边的最大值都小于分割的右半边的最小值。
这里主要是要注意边界情况。如果在partA处分割，partA左侧不包含partA处共有partA个元素，即[0, partA-1]。
所以左半边分别是[0, partA-1]和[0, partB-1]，其中partB=(m+n+1)/2-partA。
四个需要比较的极值就是partA-1，partB-1，partA以及partB。
在比较左右半边大小的时候，如果左半边的最大值大于右半边的最小值，说明左边过大，那么就要左移partA，反之右移。
这时候就有二分查找的雏形了。只要二分查找长度较小的数组找到partA位置即可。
之所以要找长度较小的那个数组，是因为既减少了搜索的space，又可以防止(m+n+1)/2-partA越界为负（partA落在边界的时候）。
最后的细节就是要搜索[0, m]，而不是[0, m)。这是因为要找的左半边是[0, partA-1]，所以m的话刚好可以把整个数组当作左半边。
*/