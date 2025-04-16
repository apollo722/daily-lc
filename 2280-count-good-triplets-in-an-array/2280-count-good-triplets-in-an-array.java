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