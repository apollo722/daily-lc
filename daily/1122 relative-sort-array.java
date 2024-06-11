/*
https://leetcode.com/problems/relative-sort-array/

因为题目元素范围有限，故用桶排序按题意模拟即可

Time: O(1)
Space: O(1)
*/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[1001];
        for (int num : arr1) m[num]++;
        int j = 0;
        for (int num : arr2) {
            while (m[num] > 0) {
                arr1[j++] = num;
                m[num]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (m[i] > 0) {
                arr1[j++] = i;
                m[i]--;
            }
        }
        return arr1;
    }
}