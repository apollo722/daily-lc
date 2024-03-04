/*
https://leetcode.com/problems/rank-transform-of-an-array/

复制原输入之后排序
对于每个元素的排名可以用map来存储
之后重新扫描复制的数组，并把每个元素的排名从map填写到结果

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[n];
        int pos = 1, idx = 0;
        for (int num : arr) {
            if (!m.containsKey(num)) m.put(num, pos++);
        }
        for (int num : copy) {
            res[idx++] = m.get(num);
        }
        return res;
    }
}