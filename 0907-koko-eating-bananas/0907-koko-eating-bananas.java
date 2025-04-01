class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = Integer.MAX_VALUE;
        int l = 1, res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int time = check(piles, mid, h);
            if (time <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private int check(int[] piles, int speed, int tar) {
        int res = 0;
        for (int num : piles) {
            if (res > tar) return tar + 1;
            if (speed >= num) res++;
            else {
                if (num % speed == 0) res += num / speed;
                else res += num / speed + 1;
            }
        }
        return res;
    }
}