class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int curSum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            curSum += cur;
            if (curSum == k) res++;
            if (m.containsKey(curSum - k)) res += m.get(curSum - k);
            m.put(curSum, m.getOrDefault(curSum, 0) + 1);
        }
        return res;
    }
}