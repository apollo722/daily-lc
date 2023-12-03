/*
https://leetcode.com/problems/subarray-sum-equals-k/

用map存储每一个位置的数字和curSum
当当前和是k时，即找到了加和为k的subarray
当map中存在curSum - k时，意味着此时与之前map存储curSum时，二者之间的subarray和为k，即应加入到结果统计中

Time: O(n)
Space: O(n)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int curSum = 0, res = 0;
        for (int num : nums) {
            curSum += num;
            if (curSum == k) res++;
            if (m.containsKey(curSum - k)) res += m.get(curSum - k);
            m.put(curSum, m.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}