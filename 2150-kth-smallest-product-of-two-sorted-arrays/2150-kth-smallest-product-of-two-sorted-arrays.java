class Solution {
    static long INF = (long) 1e10;
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int m = nums1.length, n = nums2.length;
        long lo = -INF - 1, hi = INF + 1;
        while (lo < hi) {            
            long mid = lo + ((hi - lo) / 2), cnt = 0;
            for (int num1 : nums1) {
                if (num1 >= 0) {
                    int l = 0, r = n - 1, p = 0;
                    while (l <= r) {
                        int mid2 = l + ((r - l) / 2);
                        long mul = num1 * (long) nums2[mid2];
                        if (mul <= mid) {
                            p = mid2 + 1;
                            l = mid2 + 1;
                        } else r = mid2 - 1;
                    }
                    cnt += p;
                } else {
                    int l = 0, r = n - 1, p = 0;
                    while (l <= r) {
                        int mid2 = l + ((r - l) / 2);
                        long mul = num1 * (long) nums2[mid2];
                        if (mul <= mid) {
                            p = n - mid2;
                            r = mid2 - 1;
                        } else l = mid2 + 1;
                    }
                    cnt += p;
                }
            }
            if (cnt >= k) {
                hi = mid;
            } else lo = mid + 1L;
        }
        return lo;
    }
}