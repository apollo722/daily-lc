/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int[] res = calc(nestedList, 1);
        return res[0] * maxDepth + res[1];
    }

    private int[] calc(List<NestedInteger> nestedList, int curDepth) {
        if (nestedList.size() == 0) return new int[]{0, 0};
        maxDepth = Math.max(curDepth, maxDepth);
        int[] res = new int[2];
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                res[0] += ni.getInteger();
                res[1] += (curDepth - 1) * (-ni.getInteger());
            } else {
                int[] next = calc(ni.getList(), curDepth + 1);
                res[0] += next[0];
                res[1] += next[1];
            }
        }
        return res;
    }
}