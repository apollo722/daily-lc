/*
https://leetcode.com/problems/largest-number/

按照特殊的方式排序
即如果两个数字拼接起来，a+b与b+a，更大的排在前面就能最终形成更大的数字
这样排序好之后按顺序拼接起来即可

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        for (int num : nums) pq.add(String.valueOf(num));
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) res.append(pq.poll());
        return res.charAt(0) == '0' ? "0" : res.toString();
    }
}