/*
https://leetcode.com/problems/intersection-of-two-arrays/

用set存其中一个数组的所有数字，并找另一个数组在set中存在的数字即可

Time: O(m+n)
Space: O(n)
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s = new HashSet<>();
        for (int num : nums1) s.add(num);
        HashSet<Integer> res = new HashSet<>();
        for (int num : nums2) {
            if (s.contains(num)) {
                res.add(num);
            }
        }
        int[] resArr = new int[res.size()];
        int i = 0;
        for (int num : res) resArr[i++] = num;
        return resArr;
    }
}