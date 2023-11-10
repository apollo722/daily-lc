/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/

等同于找两个linkedlist的相交点

Time: O(n)
Space: O(n)
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 = p, p2 = q;
        while (p1 != p2) {
            p1 = p1 == null ? q : p1.parent;
            p2 = p2 == null ? p : p2.parent;
        }
        return p1;
    }
}