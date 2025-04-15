class Solution {
    int[] resArr;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        resArr = new int[n];
        int[] sortedNum = nums.clone();
        solve(nums, sortedNum, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(resArr[i]);
        }
        return res;
    }

    private void solve(int[] nums, int[] sortedNum, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        solve(nums, sortedNum, l, mid);
        solve(nums, sortedNum, mid + 1, r);
        for (int i = l; i <= mid; i++) {
            int count = findCount(sortedNum, mid + 1, r, nums[i]);
            resArr[i] += count;
        }
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, p = 0;
        while (i <= mid && j <= r) {
            if (sortedNum[i] < sortedNum[j]) tmp[p++] = sortedNum[i++];
            else tmp[p++] = sortedNum[j++];
        }
        while (i <= mid) tmp[p++] = sortedNum[i++];
        while (j <= r) tmp[p++] = sortedNum[j++];
        for (int k = l; k <= r; k++) {
            sortedNum[k] = tmp[k - l];
        }
    }

    private int findCount(int[] nums, int start, int end, int tar) {
        int idx = -1, l = start, r = end;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= tar) {
                r = mid - 1;
            } else {
                idx = mid;
                l = mid + 1;
            }
        }
        return Math.max(0, idx - start + 1);
    }
}