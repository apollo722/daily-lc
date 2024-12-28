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