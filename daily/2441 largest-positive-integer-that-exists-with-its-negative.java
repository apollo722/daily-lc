/*
https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/

代码题，存一下所有的负元素，之后再扫一遍找最大的出现过相反数的元素即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (num < 0) s.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (res < num && s.contains(-num)) res = num;
        }
        return res == 0 ? -1 : res;
    }
}