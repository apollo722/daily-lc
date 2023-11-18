/*
https://leetcode.com/problems/majority-element-ii/

Boyer-Moore Voting Algorithm
初始两个变量，分别存储可能的结果
首先先把变量填满，之后开始统计个数
如果变量count归零了，证明它肯定不是最多的

最终的变量，如果填满的话，一定是数组里出现次数最多的
最后对找到的变量进行计数，看是不是满足条件

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer res1 = null, res2 = null;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (res1 != null && res1 == num) count1++;
            else if (res2 != null && res2 == num) count2++;
            else if (count1 == 0) {
                res1 = num;
                count1++;
            } else if (count2 == 0) {
                res2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (res1 != null && num == res1) count1++;
            if (res2 != null && num == res2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(res1);
        if (count2 > nums.length / 3) res.add(res2);
        return res;
    }
}