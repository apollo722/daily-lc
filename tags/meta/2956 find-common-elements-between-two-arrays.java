/*
https://leetcode.com/problems/find-common-elements-between-two-arrays/

可以用set分别存另一个出现的元素，也可以O(mn)的循环扫

Time: O(n + m)
Space: O(n + m)
*/

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        int[] res = {0, 0};
        for (int num : nums1) if (set2.contains(num)) res[0]++;
        for (int num : nums2) if (set1.contains(num)) res[1]++;
        return res;
    }
}