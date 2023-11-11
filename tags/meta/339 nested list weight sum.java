/*
https://leetcode.com/problems/nested-list-weight-sum/

DFS递归一层层计算即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        for (NestedInteger ni : nestedList) {
            res += calc(ni, 1);
        }
        return res;
    }

    private int calc(NestedInteger ni, int level) {
        if (ni.isInteger()) return ni.getInteger() * level;
        int res = 0;
        for (NestedInteger nI : ni.getList()) {
            res += calc(nI, level + 1);
        }
        return res;
    }
}