/*
https://leetcode.com/problems/random-pick-index/

蓄水池抽样模板

Time: O(n)
Space: O(1)
*/

class Solution {
    Random rand;
    int[] nums;
    public Solution(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) res = i;
            }
            
        }
        return res;
    }
}