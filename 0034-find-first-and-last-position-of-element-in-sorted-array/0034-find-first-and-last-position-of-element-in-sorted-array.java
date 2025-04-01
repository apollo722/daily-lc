class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int l = findLeft(nums, target);
        if (l == -1) return new int[]{-1, -1};
        res[0] = l;
        res[1] = findRight(nums, target);
        return res;
    }

    private int findRight(int[] nums, int tar) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > tar) {
                r = mid - 1;
            } else {
                res = mid;
                l = mid + 1;
            }
        }
        if (res != -1) {
            return nums[res] == tar ? res : -1;
        }
        return res;
    }

    private int findLeft(int[] nums, int tar) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < tar) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        if (res != -1) {
            return nums[res] == tar ? res : -1;
        }
        return res;
    }
}