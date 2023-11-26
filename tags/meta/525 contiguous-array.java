/*
https://leetcode.com/problems/contiguous-array/

标准two sum，把curSum变换成-1，1的和即可，即nums[i]为0，-1，为1则+1

Time: O(n)
Space: O(n)
*/

class Solution {
    public int findMaxLength(int[] nums) {
        int curSum = 0, res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            curSum = nums[i] == 1 ? curSum + 1 : curSum - 1;
            if (curSum == 0) {
                res = Math.max(res, i + 1);
            }
            if (m.containsKey(curSum)) res = Math.max(res, i - m.get(curSum));
            else m.put(curSum, i);
        }
        return res;
    }
}