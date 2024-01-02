/*
https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/

每扫过一个元素，只需要知道上一个它存到哪里，把它存到结果的下一个idx即可
所以只需要用一个map来记录上一个相同元素存在哪，遇到相同元素之后放到上个相同元素在结果中的下一个idx，并更新记录即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] m = new int[nums.length + 1];
        for (int num : nums) {
            if (res.size() <= m[num]) res.add(new ArrayList<>());
            res.get(m[num]++).add(num);
        }
        return res;
    }
}