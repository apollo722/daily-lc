class Solution {
    int[] resArr;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        resArr = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        solve(nums, indices, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(resArr[i]);
        }
        return res;
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