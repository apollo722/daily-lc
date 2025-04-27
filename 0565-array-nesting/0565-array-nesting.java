class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], cnt = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int tmp = start;
                    start = nums[start];
                    cnt++;
                    nums[tmp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}