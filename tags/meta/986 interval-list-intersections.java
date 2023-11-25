/*
https://leetcode.com/problems/interval-list-intersections/

因为输入有序，顺序扫描
如果二者不相交，move forward更靠前一方的index
否则找到二者的overlap，之后move更靠前一方的index

Time: O(n)
Space: O(n)
*/

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> resList = new ArrayList<>();
        int i = 0, j = 0, m = firstList.length, n = secondList.length;
        while (i < m && j < n) {
            int[] first = firstList[i], second = secondList[j];
            int start = Math.max(first[0], second[0]), end = Math.min(first[1], second[1]);
            if (start <= end) {
                resList.add(new int[]{start, end});
            } 
            if (first[1] < second[1]) i++;
            else j++;
        }
        int[][] res = new int[resList.size()][2];
        for (i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}