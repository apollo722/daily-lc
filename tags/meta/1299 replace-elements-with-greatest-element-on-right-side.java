/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

代码题

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int curMax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = curMax > arr[i] ? curMax : curMax;
            curMax = Math.max(curMax, arr[i]);
        }
        return res;
    }
}