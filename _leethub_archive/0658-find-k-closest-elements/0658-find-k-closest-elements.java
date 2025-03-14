class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, l = 0, n = arr.length, r = n - k;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid + k < n) {
                if (arr[mid + k] - x < x - arr[mid]) {
                    l = mid + 1;
                } else {
                    start = mid;
                    r = mid - 1;
                }
            } else {
                start = mid;
                r = mid - 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(arr[i + start]);
        return res;
    }
}