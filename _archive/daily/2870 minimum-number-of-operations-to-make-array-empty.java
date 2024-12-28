/*
https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/

对于任何一个数字的频率，如果能被3整除，一定每3个一起删除最快
如果不能被3整除，余1的话要匀出来1个变成4，并两次-2来归零
余2的话一次-2归零即可
如果任何数字只出现了1次，是无法被归零的

找到规律后，可以排序后统计频率，也可以O(n)用map来统计频率

Time: O(n)
Space: O(n)
*/

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int val = e.getValue();
            if (val == 1) return -1;
            if (val % 3 == 0) res += val / 3;
            else if (val % 3 == 1) res += val / 3 - 1 + 2;
            else res += val / 3 + 1;
        }
        return res;
    }
}