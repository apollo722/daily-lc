/*
https://leetcode.com/problems/queue-reconstruction-by-height/

按照身高从高到低且人数从低到高排序
这样扫描排序后的结果可以直接依据p[1]插入到结果
因为后来的人身高一定低于前面的
所以直接根据p[1]插入即为结果

Time: O(n2)
Space: O(n)
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        List<int[]> resList = new ArrayList<>();
        for (int[] p : people) {
            resList.add(p[1], p);
        }
        return resList.toArray(new int[people.length][2]);
    }
}