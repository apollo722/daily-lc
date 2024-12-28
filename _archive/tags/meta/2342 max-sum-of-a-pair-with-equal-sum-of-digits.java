/*
https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

每扫描一个元素，存储它对应的数位加和，保证map中各数位和对应的值最大即可

Time: O(n)
Space: O(1)，数位加和是有上限的，只与最大值有多少位有关，与n无关
*/

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = nums.length, res = -1;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int sum = getSum(cur);
            if (m.containsKey(sum)) {
                int prev = m.get(sum);
                res = Math.max(res, prev + cur);
                if (prev < cur) m.put(sum, cur);
            } else m.put(sum, cur);
        }
        return res;
    }

    private int getSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}