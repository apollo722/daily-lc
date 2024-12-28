/*
https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/

存储频率之后看频率是否匹配为零

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] m = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            m[target[i]]++;
            m[arr[i]]--;
        }
        for (int num : m) {
            if (num != 0) return false;
        }
        return true;
    }
}