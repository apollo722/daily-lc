class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> increaseList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (increaseList.size() == 0 || increaseList.get(increaseList.size() - 1) < cur) {
                increaseList.add(cur);
            } else {
                int idx = findFirstLarge(increaseList, cur);
                if (idx != -1) increaseList.set(idx, cur);
            }
        }
        return increaseList.size();
    }

    private int findFirstLarge(List<Integer> arr, int tar) {
        int l = 0, r = arr.size() - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cur = arr.get(mid);
            if (cur < tar) l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}