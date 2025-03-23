class Solution {
    long INF = (long) 1e10;
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int len1 = nums1.length, len2 = nums2.length;
        long lo = -INF - 1, hi = INF + 1, result = -1;
        while (lo <= hi) {
            long curTar = lo + (hi - lo) / 2, curTotalCnt = 0;
            for (int num1 : nums1) {
                if (num1 >= 0) {
                    int left = 0, right = len2 - 1, cnt = 0;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        long mul = num1 * (long) nums2[mid];
                        if (mul <= curTar) {
                            cnt = mid + 1;
                            left = mid + 1;
                        } else right = mid - 1;
                    }
                    curTotalCnt += cnt;
                } else {
                    int left = 0, right = len2 - 1, cnt = 0;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        long mul = num1 * (long) nums2[mid];
                        if (mul <= curTar) {
                            cnt = len2 - mid;
                            right = mid - 1;
                        } else left = mid + 1;
                    }
                    curTotalCnt += cnt;
                }
            }
            if (curTotalCnt >= k) {
                hi = curTar - 1;
                result = curTar;
            } else lo = curTar + 1;
        }
        return result;
    }
}
