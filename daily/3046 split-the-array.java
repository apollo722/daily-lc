/*
https://leetcode.com/problems/split-the-array/

统计频率，有频率超过2的即返回false
其实也要频率为1的元素个数为偶数个，但题目length保证了总长为偶数，故此条自动成立

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            if (m.get(num) > 2) return false;
        }
        return true;
    }
}