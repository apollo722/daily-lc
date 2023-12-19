/*
https://leetcode.com/problems/valid-square/

空间里四个点如果两两距离只有两个，即为正方形
其中，不能有0，有0证明某两个点是一个点

Time: O(1)
Space: O(1)
*/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>();
        set.add(getDist(p1, p2));
        set.add(getDist(p1, p3));
        set.add(getDist(p1, p4));
        set.add(getDist(p2, p3));
        set.add(getDist(p2, p4));
        set.add(getDist(p3, p4));
        return set.size() == 2 && !set.contains(0);
    }

    private int getDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}